package search;

public class EntryEqualToItsIndex {
    public static void main(String[] args) {
        System.out.println(entryEqualToIndex( new int[]{-2,0,2,4,6,8,9}));
    }

    /**
     *   Complexity : Log n
     * @param arr   Array of sorted  integers.
     * @return  Index of array.
     */
    public static int entryEqualToIndex(int[] arr){
        int left =0, right = arr.length, found = -1;
        while(left <= right){
            int middle = left + (right - left)/2;
            if(arr[middle] == middle){
                found = middle;
                break;
            }else if(arr[middle] > middle){
                right = middle -1;
            }else{
                left = middle +1;
            }
        }
        return found;
    }

}
