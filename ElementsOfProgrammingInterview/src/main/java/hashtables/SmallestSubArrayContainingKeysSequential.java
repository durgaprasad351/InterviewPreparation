package hashtables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestSubArrayContainingKeysSequential {

    public static void main(String[] args) {
        String[] input = "cat apple banana apple  apple dog cat apple dog banana apple cat dog".split(" ");
        List<String> keywords  = new ArrayList<>();
        keywords.add("banana");
        keywords.add("cat");
        smallestSubArraySequential(input, keywords);
    }

    private static void smallestSubArraySequential(String[] input, List<String> keywords) {

        int[]  keywordIndexArr  = new int[keywords.size()];
        for(int i =0; i < input.length; i++){
              int keywordIndex = keywords.indexOf( input[i] );
            if(keywordIndex > -1){
                keywordIndexArr[keywordIndex] =  i;
                if(keywordIndexArr.length == keywords.size()){
                    boolean isOrdered = true;
                for(int j =0;j+1 < keywordIndexArr.length  ; j++){
                    if(keywordIndexArr[j] > keywordIndexArr[j+1]){
                        isOrdered = false;
                        break;
                    }
                }
                    if(isOrdered){
                        System.out.println(  keywordIndexArr[0] +   "  " + keywordIndexArr[keywordIndexArr.length -1]
                                + "  -->   DIstance    :  " + Math.abs(keywordIndexArr[keywordIndexArr.length -1]   -keywordIndexArr[0]) );
                    }
                }
            }
        }
    }
}
