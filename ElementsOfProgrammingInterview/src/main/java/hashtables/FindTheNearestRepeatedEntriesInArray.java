package hashtables;

import java.util.HashMap;
import java.util.Map;

public class FindTheNearestRepeatedEntriesInArray {

    public static void main(String[] args) {
        int distance =   nearestRepetedDistance( new String[] {"all", "work", "and", "no", "play", "makes", "no","fun" , "and","no","result"} );
        System.out.println(distance);
    }

    private static int nearestRepetedDistance(String[] strings) {
        /**
         * Since we just need to calculate the min distance the question not asked to return the word., we can just keep the running lowest value.
         * //TODO   -->  Identify how much data we need to return , some times it will decrease the complexity dramatically.
         * I was thinking to compute the  min distance for each word, which is not asked in the question. If I need to do so I have to have another hashmap.
         */
        Map<String, Integer> lastOccuranceMap = new HashMap<>();
        int minDistance  = Integer.MAX_VALUE;
        System.out.println(minDistance);
        for(int i=0; i< strings.length; i++){
         if(lastOccuranceMap.containsKey(strings[i])){
             int lastIndex = lastOccuranceMap.get(strings[i]);
            minDistance = Math.min( minDistance , i - lastIndex );
         }
         lastOccuranceMap.put(strings[i],i);
        }
        return minDistance;
    }

}
