package _1._3;

public class FartestPair {
    /**
     * Find a farthest pair : two values whose difference is no smaller than the difference of any other pairs
     */

    public static void main(String[] args) {
        int[] input =  new int[]{15,1,8,16,10,5};
        farthestPair_linear(input);
    }

    private static void farthestPair_linear(int[] input) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i =0; i< input.length; i++){
            if(min > input[i]){
                min = input[i];
            }
            if(max < input[i]){
                max = input[i];
            }
        }
        System.out.println( min + " " + max );
    }
}
