package hashtables;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithDistinctEntries {

    public static void main(String[] args) {
        String[]  words = "f s f e t w e n w e ".split(" ");
        longestSubArrayWithDistinctEntries(words);
    }

    private static void longestSubArrayWithDistinctEntries(String[] words) {
        Map<String, Integer> wordIndexMap =  new HashMap<>();
        for(int i=0 ;i < words.length;){
            if(wordIndexMap.containsKey( words[i] )){
                System.out.println( wordIndexMap );
                String w = words[i];
                i = wordIndexMap.get( words[i] ) + 1;
                wordIndexMap.clear();
            }else{
                wordIndexMap.put( words[i], i++ );
            }
        }
    }
}
