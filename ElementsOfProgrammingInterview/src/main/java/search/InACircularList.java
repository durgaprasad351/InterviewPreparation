package search;

public class InACircularList {

    public static void main(String[] args) {
        System.out.println( searchSmallestInCircularList( new int[]{5,6,7,8,9,10,1,2,3,4} ));

        System.out.println( searchSmallestInCircularList( new int[]{1,2,3,4,5,6,7,8,9,10} ));
    }

    private static int  searchSmallestInCircularList(int[] arr) {
        int left =0, right = arr.length -1;
        while(left <= right){
            int middle = left + (right - left)/2;
            if(arr[middle] > arr[right]){
                left = middle +1;
            }else{
                right = middle-1;
            }
        }
        return left;
    }
}
