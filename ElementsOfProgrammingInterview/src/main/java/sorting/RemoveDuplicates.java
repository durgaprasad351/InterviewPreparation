package sorting;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        removeDuplicates(new int[] { 1,4,5,6,2,6,4,5});
        removeDuplicates(new int[] { 1,2,3,4,5});
    }

    private static void removeDuplicates(int[] vals) {
        Arrays.sort( vals);
        int writeIndex = 0;
        int readIndex = 1;
       while(readIndex < vals.length){
           if( vals[writeIndex] != vals[readIndex] ){
               vals[++writeIndex] = vals[readIndex];
           }
           readIndex++;
       }
        System.out.println(Arrays.toString(Arrays.copyOf( vals,  writeIndex +1  )));
    }
}
