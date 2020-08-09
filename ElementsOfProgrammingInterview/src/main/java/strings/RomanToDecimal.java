package strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {

    public static void main(String[] args) {
        System.out.println(romanToDecimal("LIX"));
        System.out.println(romanToDecimal("LVIIII"));
        System.out.println(romanToDecimal("XXXXXIIIIIIIII"));
    }

    public static int romanToDecimal(String roman) {
        int res = 0;
        Map<Character, Integer> DICT = new HashMap();
        DICT.put('I', 1);
        DICT.put('V', 5);
        DICT.put('X', 10);
        DICT.put('L', 50);
        DICT.put('D', 100);
        DICT.put('M', 500);

        for (int i = roman.length() -1; i >= 0; i--) {
            if( i-1 > -1 && DICT.get(roman.charAt(i-1)) < DICT.get(roman.charAt(i))){
                res += DICT.get(roman.charAt(i)) - DICT.get(roman.charAt(i-1));
                i--;
            }else{
                res += DICT.get(roman.charAt(i));
            }
        }
        return res;
    }

}
