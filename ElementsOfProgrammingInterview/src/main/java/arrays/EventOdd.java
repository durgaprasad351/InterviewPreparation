package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class EventOdd {

    /*

In:
    [1,2,3,4,5,6]

    Move all the even to left and odd to right

    Also know as Two pointer

Out:
    [2,4,6,1,3,5]

//
Missed end variable initialization

     */

    public static void main(String[] args) {
        int[] res =  evenOdd( new int[]{1,2,3,4,5,6});
        System.out.println( Arrays.toString(res) );
    }

    public static int[] evenOdd(int[] a){
        //Two pointers event and odd
        //event to start
        int even = 0;
        //End to end of array
        int odd = a.length-1;
        //Iterate till even < odd
        while(even < odd) {
            //if ele at index is even
            if(a[even] % 2 == 0) {
                //move even
                even++;
            }else {    //if ele at index is odd
                //swap element with element at odd
                int tmp = a[odd];
                a[odd] = a [even];
                a[even] = tmp;
                // odd--
                odd--;
            }
        }
        return a;
    }

}
