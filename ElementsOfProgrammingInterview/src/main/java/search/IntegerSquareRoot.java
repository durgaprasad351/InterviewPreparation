package search;

/**
 * For a given integer find a number which is less than the given number and also who's sqrt is less than or equal to  given number
 */
public class IntegerSquareRoot {

    public static void main(String[] args) {
        System.out.println(  sqrtFinder(16));

        System.out.println(  sqrtFinder(300));
    }

    public static int sqrtFinder( int max ){
        int left = 0,  right = max, found = -1;
        while(left  <=  right){
            int middle = left + (right - left)/2;
            int middleSqrt = middle * middle;
            if(middleSqrt  <= max) {
                found = middle;
                left = middle +1;
            }else{
                right = middle -1;
            }
        }
        return found;
    }
}
