package hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringDecompositions {

    public static void main(String[] args) {
        stringDecomposition(" amanaplanacanal", new ArrayList<String>(Arrays.asList( "can" ,"apl", "ana" )));
    }

    private static void stringDecomposition(String s, List<String> words) {
        long targetHash = 0;
        int length = 0;
        for(String str : words){
            targetHash += basicHash(str);
            length += str.length();
        }
        for(int i=0 ; i+ length < s.length(); i++){
            String subStr = s.substring(i, i+ length);
            long hash = basicHash(subStr);
            if(targetHash == hash){
                Set<String> wordSet = new HashSet<>(words);
                int wordLength = words.get(0).length();
                boolean matches = true;
                System.out.println("Potential : " + subStr);
                for(int j= 0; (j + wordLength) <  length  ; j+= wordLength){
                    if(!wordSet.contains( subStr.substring(j, j+wordLength))){
                        matches = false;
                    }
                }
                if(matches){
                    System.out.println( "Found : " + subStr );
                }
            }
        }
    }

    private static long basicHash(String word){
        long hash = 0;
        for(char c : word.toCharArray()){
            hash += c - 'A';
        }
        return hash;
    }

}
