package _1._4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeSortThreeWay {

    public static void main(String[] args) {
        int[] sorted = new int[] { 3, 1, 7, 5, 9, 2, 4, 6, 8 };
        mergeSort(sorted, 0, sorted.length - 1);
        System.out.println(Arrays.toString(sorted));

        sorted = new int[] { 3,1,2 };
        mergeSort(sorted, 0, sorted.length - 1);
        System.out.println(Arrays.toString(sorted));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        System.out.println("Start : " + start + " End : " + end);
        if (end == start)
            return;
        // Splitting array into 3 parts
        int mid1 = start + ((end - start) / 3);
        int mid2 = start + 2 * ((end - start) / 3) + 1;
        mergeSort(arr, start, mid1);
        mergeSort(arr, mid1 + 1, mid2);
        mergeSort(arr, mid2 + 1, end);
        mergeThreeArrays(arr, start, mid1, mid1 + 1, mid2, mid2 + 1, end);
    }

    private static void mergeThreeArrays(int[] arr, int start1, int end1, int start2, int end2, int start3, int end3) {
        int i = start1, j = start2, k = start3;
        int c = 0;
        int[] scratch = new int[end3 - start1 + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.add(arr[i]);
        minHeap.add(arr[j]);
        minHeap.add(arr[k]);
        while (c < scratch.length) {
            int min = minHeap.poll();
            if (min == arr[i]) {
                if(i < end1){
                    i++;
                    minHeap.add(arr[i]);
                }
            }
            if (min == arr[j]) {
                if(j < end2){
                    j++;
                    minHeap.add(arr[j]);
                }
            }
            if (min == arr[k]) {
                if(k < end3){
                    k++;
                    minHeap.add(arr[k]);
                }
            }
            scratch[c++] = min;
        }

        for (c = 0, i = start1; c < scratch.length; c++, i++) {
            arr[i] = scratch[c];
        }
    }

}
