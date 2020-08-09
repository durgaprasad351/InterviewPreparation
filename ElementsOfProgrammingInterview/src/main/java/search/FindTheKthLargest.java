package search;

import collections.ArrayUtils;

public class FindTheKthLargest{

    public static void main(String[] args) {
        System.out.println( findKthLargest(new int[] {2,1,3,4,5}, 3));

        System.out.println( findKthLargest(new int[] {2,1,3,4,5}, 4));

        System.out.println( findKthLargest(new int[] {1,2,3,4,5,6,7}, 4));
    }

    /**
     *   Allways use the zero item for partition, just for simplicity.
     *   Better approach will be to chose a random element.
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public  static int  partition(int[] arr , int start, int end){
        int pivot = start;
        int low = start +1;
       int  high = end;
        while(low <= high){
                if(arr[pivot ] >  arr[low]){
                    ArrayUtils.swap( arr, pivot , low );
                    pivot = low;
                    low++;
                }else if(arr[pivot] < arr[low]){
                    ArrayUtils.swap(arr, low, high);
                    high --;
                }
        }
        return pivot;
    }

    public static  int findKthLargest(int[] arr, int k){
     int  pivot = 0;
     int  start = 0;
     int end = arr.length -1;
     k =  arr.length  - k;
    do{
        pivot = partition(arr, start, end);
        System.out.println(  " Start  -> " + start + " , End ->  " + end + " , Pivot -> " + pivot);
        if(pivot > k){
            //Search between  start and pivot
            end = pivot -1;
        }else if(pivot < k){
          start = pivot + 1;
        }
    }while(pivot != k);
    return arr[k];
    }

}
