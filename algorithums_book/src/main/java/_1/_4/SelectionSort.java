package _1._4;

public class SelectionSort  extends  AbstractSort {

    public static void main(String[] args) {
        SelectionSort selectionSort  =  new SelectionSort();
        selectionSort.sort( new int[]{5,3,1,2,4});
    }

    void sort(int[] arr) {
        //In every iteration  smallest number in the sub array will be moved to the left.

        for(int i=0; i< arr.length -1; i++){  // (n-1)
            //Iterate
            for(int j = i+1; j >= 1; j--){  // (1,2,3..(n)) = n(n+1)/2
                if(arr[j-1] < arr[j]){
                    swap(arr, j-1, j);
                }
            }
        }
        //Total Iterations is (n-1) * n(n+1)/2 = o(n^2)
        print(arr);
    }
}
