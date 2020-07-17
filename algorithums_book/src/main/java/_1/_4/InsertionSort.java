package _1._4;

/**
 * Given an array of integers foreach iteration identify the Min element in the rest of the array  and insert
 */
public class InsertionSort extends AbstractSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(new int[]{5,3,1,2,4});
        insertionSort.sort(new int[]{10,9,8,7,6,5,4,3,2,1});
    }

    public  void sort(int[] arr){
        for(int i=0; i< arr.length; i++){
            int minIndex = i;
            for(int j=i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
        print(arr);
    }
}
