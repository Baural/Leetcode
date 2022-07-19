package com.prinston.week3;

/**
 * @author Baurzhan Alzhanov
 * @date on 24.02.2021
 */


public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        //edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(global, local);
        }
//        System.out.println(global);
        return global;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaximumSubarray m = new MaximumSubarray();
        int[] nums = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
        int r = m.maxSubArray(nums);
        System.out.println(r);
    }

}
