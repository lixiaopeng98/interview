package com.interview.demo.algorithm;

import java.util.Arrays;

public class TestClass {

    public static int[] seekNum(int[] nums, int sumNum){

        for (int k = 0; k < nums.length; k++) {
            int num = nums[k];
            int i = sumNum - num;
            int p = Arrays.binarySearch(nums, i);
            if (p > 0){
                System.out.println(i + ";p=" + p);
                return new int[]{k,p};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] cc = new int[]{1,3,5,7,9,20};
        int[] ints = seekNum(cc, 10);
        Arrays.stream(ints).forEach(item -> {
            System.out.println(item);
        });
    }
}
