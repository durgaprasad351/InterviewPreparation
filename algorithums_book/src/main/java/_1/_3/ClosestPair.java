package _1._3;

import java.util.Arrays;
import java.util.Collections;

public class ClosestPair {
    /**
     * Given an array of  integers find the closest pair: two values who's difference is no greater than the difference of any other pairs.
     *
     * Hint:
     *
     * Sorting the values will help in reducing the runtime from quadratic to linerthemic n*log n
     */

    public static void main(String[] args) {
        int[] input =  new int[]{15,1,8,16,10,5};
        closestPairUsing_Sorting(input);
        closestPair_Quadratic(input);
    }

    private static void closestPair_Quadratic(int[] input) {
        int diff = Integer.MAX_VALUE;
        int p1 = -1, p2=-1;
        for(int i=0;i< input.length;i++){
            for(int j=i+1; j< input.length; j++){
                int tmp = Math.abs(input[i] - input[i+1]);
                if( diff > tmp){
                    diff = tmp;
                    p1 = i;
                    p2=j;
                }
            }
        }
        System.out.println( input[p1]  + " " + input[p2]);
    }

    private static void closestPairUsing_Sorting(int[] input) {
        Arrays.sort(input);
        int diff = Integer.MAX_VALUE;
        int index = -1;
        for(int i =0; i< input.length -1; i++){
            int tmp = Math.abs(input[i] - input[i+1]);
            if( diff > tmp){
                diff = tmp;
                index = i;
            }
        }
        System.out.println( input[index]  + " " + input[index+1]);
    }
}
