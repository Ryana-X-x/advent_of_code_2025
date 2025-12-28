// need to count how many rotations point at 0 when the dial is starting at 50

import java.io.* ;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        int position = 50 ;
        int zeroCount = 0 ;

        String line ;
        while ((line = br.readLine()) != null && ! line.isEmpty()) {
            char dir = line.charAt(0) ;
            int steps = Integer.parseInt(line.substring(1)) ;

            if (dir == 'L') {
                position -= steps ;
            } else {
                position += steps ;
            }

            position = ((position % 100) + 100 %  100) ;

            if (position == 0) {
                zeroCount++ ;
            }
        }

        System.out.println(zeroCount);
    }
}