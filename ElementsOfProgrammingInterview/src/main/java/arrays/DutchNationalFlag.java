package arrays;

import collections.ArrayUtils;

import java.util.Arrays;

public class DutchNationalFlag {
    /*

        Input : [1,2,3,1,2,3]
        Given a set of three different groups arrange the group in such a way that pivot element stays in the middle
        and every thing less than pivot moves to left and greater moves to right

        Also known as three pointer approach problem

        Output : [1,1,2,2,3,3]

     */

    public static void main(String[] args) {
        int[] res = partiton(new int[]{1,2,3,1,2,3}, 1);
        System.out.println(Arrays.toString(res));
    }

    public static int[] partiton(int[] a, int p) {
        //Use Three pointers less l, middle m and greater g
        int l = 0, m = 0, g = a.length - 1;
        //Move till middle and great meets
        while (m <= g) {
            if (a[m] < p) {
                ArrayUtils.swap(a, m, l);
                l++;
                m++;
            } else if (a[m] == p) {
                m++;
            } else if (a[m] > p) {
                ArrayUtils.swap(a, m, g);
                g--;
            }
        }
        return a;
    }


}
