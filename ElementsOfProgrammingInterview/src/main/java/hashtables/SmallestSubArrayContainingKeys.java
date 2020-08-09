package hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestSubArrayContainingKeys {
    public static void main(String[] args) {
        String[] input = "apple banana apple  apple dog cat apple dog banana apple cat dog".split(" ");
        Set<String> keywords  = new HashSet<>();
        keywords.add("banana");
        keywords.add("cat");
        smallestSubArray(input, keywords);

        input = "2 2 4 5 8 9".split(" ");
        keywords  = new HashSet<>();
        keywords.add("2");
        keywords.add("5");
        keywords.add("9");
        smallestSubArray(input, keywords);

        input = "A D O B E C O D E B A N C".split(" ");
        keywords  = new HashSet<>();
        keywords.add("A");
        keywords.add("B");
        keywords.add("C");
        smallestSubArray(input, keywords);


    }

    public static void smallestSubArray(String[] input, Set keywords){
        Map<String, Integer>  keyWordOccurances = new HashMap<>();
        for(int i =0; i < input.length; i++){
            if(keywords.contains( input[i] )){
                keyWordOccurances.put( input[i],i );
                if(keyWordOccurances.size() ==  keywords.size()){
                    //We got all the key words .. Start comparing...
                    System.out.println(  keyWordOccurances );
                    List<Integer> sorted = new ArrayList<>( keyWordOccurances.values());
                    Collections.sort( sorted);
                    System.out.println( sorted.get( 0 )    + "  :  " + sorted.get( sorted.size() -1 )   +  "--> Distance  :   " + (    Math.abs(sorted.get( 0 )  - sorted.get( sorted.size() -1 )  )   ) );
                }
            }

        }
    }

}
