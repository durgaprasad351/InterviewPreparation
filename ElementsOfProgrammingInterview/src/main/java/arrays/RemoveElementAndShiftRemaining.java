package arrays;

import java.util.Arrays;

public class RemoveElementAndShiftRemaining {

    public static void main(String[] args) {
        int[] res = removeElement(new int[] {1,2,3,4,1,2,3,4}, 4);
        System.out.println(Arrays.toString(res));
    }

    public static int[] removeElement(int[] arr, int t){
        int p=0;
        for(int i=0; i< arr.length; i++){
            if(arr[i] != t                                                                                                  ){
                arr[p] = arr[i];
                p++;
            }
        }
        System.out.println("New Array Size " +  p);
        return Arrays.copyOf(arr, p);
    }
}
