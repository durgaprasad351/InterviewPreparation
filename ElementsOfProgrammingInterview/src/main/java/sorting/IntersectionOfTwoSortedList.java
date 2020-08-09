package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedList {

    // 1. We can  do binary search , since items are sorted .... N Log N
    //2.Store one list in HashSet and iterate the other list to check  .... Storage O(N)  but runtime is just O(N)..
    //3. Iterate both the list with two pointers and search
    public static void main(String[] args) {
       List<Integer> common =    intersetion(Arrays.asList( 1,2,3,5,6,7 ), Arrays.asList( 3,4,5 ));
        System.out.println(common);
    }

    private static List<Integer> intersetion(List<Integer> list1, List<Integer> list2) {
        List<Integer> common = new ArrayList<>();
        int p1=0, p2 =0;
      while(p1 < list1.size() && p2 < list2.size()){
          if(list1.get(p1) == list2.get(p2)){
              common.add(list1.get(p1));
              p1++;
              p2++;
          }else if(list1.get(p1) < list2.get(p2)){
              p1++;
          }else{
              p2++;
          }
      }
      return common;
    }
}
