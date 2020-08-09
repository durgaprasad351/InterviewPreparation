package hashtables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class FindTheLengthOfALongestContainedInterval {

    public static void main(String[] args) {
        int[]  arr = new int[]{3,-2,7,9,8,1,2,0,-1,5,8};
        longestInterval_Brute_Force(arr);
        longestInterval_optimal(arr);
    }

    private static void longestInterval_optimal(int[] arr)  {
      HashSet<Integer>  unExplored = new HashSet<>( );
      for(int i : arr) unExplored.add(i);
      int maxRange = 0;
      while(! unExplored.isEmpty()){
          int e = unExplored.iterator().next();
          int lower = e-1;
          unExplored.remove(e);
          while(unExplored.contains(lower)){
              unExplored.remove(lower);
              lower = lower-1;
          }
          int higher = e +1;
          while(unExplored.contains(higher)){
              unExplored.remove(higher);
              higher = higher+1;
          }
          maxRange = Math.max( maxRange , higher - lower -1);
      }
        System.out.println("MAx Range : " + maxRange );
    }

    private static void longestInterval_Brute_Force(int[] arr) {
        TreeSet<Integer>  intervalSet = new TreeSet<>();
        for(int i : arr){
                intervalSet.add(i);
        }
        Arrays.sort( arr );
        int count = 1;
        for(int i =0 ;i+1 < arr.length ; i++  ){
            if(arr[i+1] == arr[i] + 1){
                count++;
            }else{
                System.out.println(count);
                count = 0;
            }
        }


    }

}
