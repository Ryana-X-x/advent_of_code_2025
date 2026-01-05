def parse_ranges(input_string):
    ranges = []
    range_strings = input_string.split(",") 

    for range_str in range_strings:
        start_str, end_str = range_str.split("-")
        start = int(start_str)
        end = int(end_str)
        ranges.append((start, end))
    
    return ranges

def create_double_number(half, half_length):
    return half * (10 ** half_length) + half

def generate_double_numbers(half_length, max_value):
    double_numbers = []

    min_half = 10 ** (half_length - 1)
    smallest_double = create_double_number(min_half, half_length)

    if smallest_double > max_value:
        return double_numbers
    
    max_half= (10 ** half_length) - 1

    for half in range(min_half, max_half + 1):
        doubled = create_double_number(half, half_length)

        if doubled > max_value:
            break

        double_numbers.append(doubled)

    return double_numbers

def is_in_range(number, ranges):
    for start, end in ranges:
        if start <= number <= end:
            return True 
    return False

def max_value(ranges):
    max_val = 0
    for start, end in ranges:
        max_val = max(max_val, end)
    return max_val

# --------- main logic --------------
input_string = (
    "1061119-1154492,3-23,5180469-5306947,21571-38630,1054-2693,141-277,"
    "2818561476-2818661701,21177468-21246892,40-114,782642-950030,"
    "376322779-376410708,9936250-10074071,761705028-761825622,"
    "77648376-77727819,2954-10213,49589608-49781516,9797966713-9797988709,"
    "4353854-4515174,3794829-3861584,7709002-7854055,7877419320-7877566799,"
    "953065-1022091,104188-122245,25-39,125490-144195,931903328-931946237,"
    "341512-578341,262197-334859,39518-96428,653264-676258,304-842,"
    "167882-252124,11748-19561"
)

ranges = parse_ranges(input_string)
maximum = max_value(ranges)

total_sum = 0

half_length = 1
while True:
    min_half = 10 ** (half_length - 1)
    smallest_double = create_double_number(min_half, half_length)

    if smallest_double > maximum:
        break

    doubled_numbers = generate_double_numbers(half_length, maximum)
    for number in doubled_numbers:
        if is_in_range(number, ranges):
            total_sum += number

    half_length += 1


print("sum of invalid IDs: ", total_sum)
