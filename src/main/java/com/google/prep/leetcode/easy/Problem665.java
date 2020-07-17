package com.google.prep.leetcode.easy;

import com.sun.tools.javac.util.Assert;

public class Problem665 {

    /**
     * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
     *
     * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
     *
     * Example 1:
     * Input: [4,2,3]
     * Output: True
     * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
     * Example 2:
     * Input: [4,2,1]
     * Output: False
     * Explanation: You can't get a non-decreasing array by modify at most one element.
     * Note: The n belongs to [1, 10,000].
     */

    public static void main(String[] args) {
        Assert.check( true == checkPossibility(new int[]{1,2,3}));
        Assert.check( false == checkPossibility(new int[]{3,2,1}));
        Assert.check( true == checkPossibility(new int[]{2,1}));
        Assert.check( true == checkPossibility(new int[]{1,2,3,9,5,6}));
        Assert.check( true == checkPossibility(new int[]{1,3,2,2,2}));

        Assert.check( true == checkPossibility(new int[]{3,1}));
        Assert.check( true == checkPossibility(new int[]{1,1,1}));
        Assert.check( true == checkPossibility(new int[]{1}));
        Assert.check( false == checkPossibility(new int[]{4,2,1}));
        Assert.check( true == checkPossibility(new int[]{4,2,3}));
        Assert.check( false == checkPossibility(new int[]{3,4,2,3}));
        Assert.check( true == checkPossibility(new int[]{2,3,3,2,4}));
    }

    public static boolean checkPossibility(int[] arr) {
       int fails = 0;
       int good = 0;
       int curr =1;
       while(curr < arr.length){
           if(arr[good] <= arr[curr]){
               good = curr;
               curr++;
           }else{
               if(good != 0) {
                   good--;
               }else{
                   //good++;
                   curr++;
               }
               fails ++;
           }
       }
       return  fails <= 1;
    }
}
