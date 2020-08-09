package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        List<Integer> merged = mergeSortedArr(Arrays.asList(1,3,5,7), Arrays.asList(2,4,6,8));
        System.out.println(merged);
        merged = mergeSortedArr(Arrays.asList(1), Arrays.asList(2));
        System.out.println(merged);

        mergeSortedArrayWithEmptySPace( new int[]{1,3,5,7,-1,-1,-1,-1,-1,-1}, 4,new int[]{2,4,6,8});
        mergeSortedArrayWithEmptySPace( new int[]{3,5,7,-1,-1,-1,-1,-1,-1}, 3,new int[]{1,2,4,6,8});
        mergeSortedArrayWithEmptySPace( new int[]{1,3,5,7,8,-1,-1,-1,-1,-1}, 5,new int[]{});
        mergeSortedArrayWithEmptySPace_TextBook(new int[]{1,3,5,7,8,-1,-1,-1,-1,-1}, 5,new int[]{});
        mergeSortedArrayWithEmptySPace_TextBook(new int[]{3,5,7,-1,-1,-1,-1,-1,-1}, 3,new int[]{1,2,4,6,8});
    }

    private static void mergeSortedArrayWithEmptySPace_TextBook(int[] big, int size, int[] small) {
    int writeIndx  = size + small.length -1;
    int bigIndex = size -1;
    int smallIndx = small.length -1;
    while(smallIndx > -1 && bigIndex > -1){
      big[writeIndx --] = big[bigIndex] > small[smallIndx]  ?   big[bigIndex--] : small[smallIndx --];
    }
    while(smallIndx > -1){
        big[writeIndx--] = small[smallIndx--];
    }
        System.out.println( Arrays.toString(big) );
    }

    private static void mergeSortedArrayWithEmptySPace(int[] bigList, int size, int[] smallList) {
    int big = size + smallList.length -1;
    int small = smallList.length -1;
    size--;
    while(small > -1 ||  size > -1){
        boolean moveSmall = false;
        if( small > -1 && size < 0  ){
            moveSmall = true;
        }else if(size > -1 && small <0){
            moveSmall = false;
        }else if(bigList[ size ] > smallList[small]){
            moveSmall = false;
        }else{
            moveSmall = true;
        }

        if(moveSmall){
            bigList[big] =  smallList[small];
            small--;
        }else{
            bigList[big] =  bigList[size];
            size--;
        }
        big --;
    }
        System.out.println( Arrays.toString(bigList)  );
    }

    private static List<Integer> mergeSortedArr(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int p1 = 0, p2=0;
        while(p1 < list1.size() && p2 < list2.size()){
            if(list1.get(p1) < list2.get(p2)){
                merged.add(list1.get(p1++));
            }else{
                merged.add(list2.get(p2++));
            }
        }
        List<Integer> remainingList = (p1 == list1.size()) ?  list2 : list1;
        int p = (p1 == list1.size()) ?  p2 : p1;
        while(p < remainingList.size()){
            merged.add(remainingList.get(p++));
        }
        return merged;
    }
}
