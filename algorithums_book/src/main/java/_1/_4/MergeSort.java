package _1._4;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] sorted = new int[] { 3,1, 7, 5, 9, 2, 4, 6, 8 };
        mergeSort(sorted, 0, sorted.length-1);
        System.out.println(Arrays.toString(sorted));

        sorted = new int[] { 3,1};
        mergeSort(sorted, 0, sorted.length-1);
        System.out.println(Arrays.toString(sorted));

        sorted = new int[] { 1};
        mergeSort(sorted, 0, sorted.length-1);
        System.out.println(Arrays.toString(sorted));
    }

    public static void mergeSort(int[] arr, int start, int end) {

        if (start == end)
            return;

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);

        mergeSort(arr, mid + 1, end);

        mergeTwoSortedArrays( arr, start, mid, mid+1, end );
    }

    private static void mergeTwoSortedArrays(int[] arr, int start1, int end1, int start2, int end2) {
        int[] scratch = new int[ Math.max( end1, end2 ) - Math.min(start1, start2 ) +1];
        int c =0;
        int i = start1;
        int j = start2;
        while(c < scratch.length){
            if(i <= end1 && j <= end2){
                if(arr[i] < arr[j]){
                    scratch[c] = arr[i++];
                }else{
                    scratch[c] = arr[j++];
                }
            }else if(i <= end1 && j > end2){
                scratch[c] = arr[i++];
            }else if(i > end1 && j <= end2){
                scratch[c] = arr[j++];
            }
            c++;
        }

        i = Math.min(start1, start2);
        for( c = 0; c < scratch.length; c++, i++){
            arr[i] = scratch[c];
        }

    }


}