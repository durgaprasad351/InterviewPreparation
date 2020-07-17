package _1._3;

public class LocalMinumum {

    public static final int INT = 0;

    /**
     * Local Minumum of an Array :
     * Given an array a[] of distinct integers
     * Given an array find the element that is less than its neighbours.
     * Best Case :  Logn
     * Worst Case :  n
     */

    public static void main(String[] args) {
        int[] input = new int[]{9, 6, 3, 14, 5, 7, 4};
        solution_linear(input);
        solution_logarithmic(input);
    }

    /**
     * Use Binary Search. Start from middle if left is smaller than middle go to left or move to right.
     * @param input
     */
    private static void solution_logarithmic(int[] input) {
       int val = helper(input, 0, input.length -1, input.length /2 );
        System.out.println(val);
    }

    private static int  helper(int[] input, int start, int end, int middle){
        System.out.println("Start : " + start + " End :" + end + " Middle :" + middle);
        if(start == middle || end == middle) return -1;
        if( isLessThanLeft(input, middle) && isLessThanRight(input, middle)){
            return middle;
        }
        int val = -1;
        if(isLessThanLeft(input, middle)){
             val = helper(input, start, middle , (middle-start)/2);
        } else{
            val = helper(input, middle, end, middle + (end-middle)/2) ;
        }
        return val;
    }

    private static boolean isLessThanRight(int[] input, int middle) {
        if (middle == input.length -1)
            return false;
        return middle <  input.length  && input[middle] < input[middle+1];
    }

    private static boolean isLessThanLeft(int[] input, int middle) {
        if (middle == 0)
            return false;
        return middle > 0  && input[middle] < input[middle-1];
    }

    private static void solution_linear(int[] input) {
        for(int i =1 ; i < input.length -1 ; i++){
            if(input[i] < input[i-1] && input[i] < input[i+1]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

}
