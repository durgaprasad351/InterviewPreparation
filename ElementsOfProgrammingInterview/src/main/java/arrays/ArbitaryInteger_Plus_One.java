package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArbitaryInteger_Plus_One {


    public static void main(String[] args) {
        List<Integer>  longInt = Arrays.asList(9,9,9);
        longInt = longInt_Addition(longInt, 1);
        System.out.println(longInt);
    }

    /**
     * Assuming the list has MSD at 0 and LSD at the end of the list
     * @param longInt
     * @param v
     * @return
     */
    public static List<Integer> longInt_Addition(List<Integer> longInt, int v){
        //{9,9,9}
        // Start adding from n and if there is any carry at the end just insert at zero position
        int carry =0;
        for(int i = longInt.size()-1; i > -1; i--){
            int tmp = longInt.get(i) + carry;
            if(i == longInt.size() -1){
                tmp += v;
            }
            carry = tmp/10;
            tmp = tmp%10;
            longInt.remove(i);
            longInt.add(i, tmp);
        }

        if(carry > 0){
            longInt.add(0, carry);
        }
        return longInt;
    }
}
