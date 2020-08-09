package search;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch( new int[]{1,2,3,4,5}, 3 ));
        System.out.println(binarySearch( new int[]{1,2,3,4,5,6,7,8,9,10}, 1));
        System.out.println(binarySearch( new int[]{1,2,3,4,5,6,7,8,9,10}, 10));
    }

    /**
     *  Binary search
     * @param arr  A sorted array fo integers
     * @param target  Integer to find in the given array
     * @return Returns the index of item  if found or returns -1 if not found.
     */
    public static  int binarySearch(int[ ] arr, int target  ){
        int found = -1;
        int left = 0 , right = arr.length;
        //TODO Be care full this should be less than of equal not just  less than
        while(left  <= right){
            //TODO Better than computing left+right /2 ... to avoid integer over flow.
            int middle = left + (right - left) /2;
            if(arr[middle] == target){
                found =  middle;
                break;
            }else if (arr[middle] > target){
                right = middle -1;
            }else{
                left = middle +1;
            }
        }
        return  found;
    }
}
