package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MnemonicsPhoneNumber {

    public static void main(String[] args) {
        System.out.println( generateMnemonics("223") );


    }

    static String[] DICT = new String[]{"0","1", "ABC", "DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};



    public static List<String> generateMnemonics(String phoneNumber){
        return permute( phoneNumber, 0, "" );
    }

    public static List<String> permute( String source, int start, String preFix){

        if(start == source.length()){
            return Arrays.asList(preFix);
        }

        List<String> list = new ArrayList<String>();
        for(int i=0; i < DICT[ source.charAt(start)- '0'].length(); i++){
            list.addAll( permute( source, start+1, preFix + "" + DICT[ source.charAt(start)- '0'].charAt(i)));
        }

        return list;
    }
}
