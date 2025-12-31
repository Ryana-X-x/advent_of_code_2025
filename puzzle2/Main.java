package puzzle2;
import java.util.* ;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "1061119-1154492,3-23,5180469-5306947,21571-38630,1054-2693,141-277,2818561476-2818661701,21177468-21246892,40-114,782642-950030,376322779-376410708,9936250-10074071,761705028-761825622,77648376-77727819,2954-10213,49589608-49781516,9797966713-9797988709,4353854-4515174,3794829-3861584,7709002-7854055,7877419320-7877566799,953065-1022091,104188-122245,25-39,125490-144195,931903328-931946237,341512-578341,262197-334859,39518-96428,653264-676258,304-842,167882-252124,11748-19561" ;

        List<long[]> ranges = parseRanges(input) ;

        System.out.println(ranges);
                        
    }

    private static List<long[]> parseRanges(String input) {
        List<long[]> ranges = new ArrayList<>() ;
        String[] rangeStrings = input.split(",") ;
        
        for(String rangeStr : rangeStrings) {
            String[] parts = rangeStr.split("-") ;
            long start = Long.parseLong(parts[0]) ;
            long end = Long.parseLong(parts[1]) ;
            ranges.add(new long[] {start, end}) ;
        }

        return ranges ;
    }

    private static long createDoubleNumer(long half, int halfLength) {
        return half = half * (long) Math.pow(10, halfLength) + half ;
    }

    private static List<Long> generateDoubleNumber(int halfLength, long maxValue) {
        List<Long> doubleNumber = new ArrayList<>() ; 

        // find the min half
        long minHalf = (long) Math.pow(10, halfLength - 1) ;

        long smallestDoubles = createDoubleNumer(minHalf, halfLength) ;
        if (smallestDoubles > maxValue) {
            return doubleNumber ;
        }

        long maxHalf = (long) Math.pow(10, halfLength) - 1 ;
        
        for(long half = minHalf; half <= maxHalf; half++) {
            long doubled = createDoubleNumer(half, halfLength) ;

            if (doubled > maxValue) {
                break ;
            }

            doubleNumber.add(doubled) ;
        }

        return doubleNumber ;
 
    }

    private static boolean isInRange(long num, List<long[]> ranges) {
        for(long[] range : ranges) {
            if (num >= range[0] && num <= range[1]) {
                return true ;
            }
        }
        return false ;
    }

    private static long maxValue(List<long[]> ranges) {
        long maxValue = 0 ;
        for (long[]range : ranges) {
            maxValue = Math.max(maxValue, range[1]) ;
        }
        return maxValue ;
    }
}
