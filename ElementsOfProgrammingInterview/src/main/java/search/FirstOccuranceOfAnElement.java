package search;

public class FirstOccuranceOfAnElement {

    public static void main(String[] args) {
        System.out.println(firstOccurance( new int[]{1,2,3,3,4,5}, 3 ));
        System.out.println(firstOccurance( new int[]{1,2,3,4,5,6,7,8,9,10,10,10}, 10));
        System.out.println(firstOccurance( new int[]{1,1,1,2,3,4,5,6,7,8,9,10}, 1));

    }

    public static int firstOccurance(int[] arr, int target) {
        int left =0, right = arr.length , found = -1;
        while(left <= right){
            int middle = left + (right - left) /2;
            if(arr[middle] == target){
                found = middle;
                right = middle -1;
            }else if ( arr[middle] < target ){
                left = middle +1;
            }else{
                right = middle -1;
            }
        }
        return found;
    }


}
