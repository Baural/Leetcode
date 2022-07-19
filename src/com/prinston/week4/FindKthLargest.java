package com.prinston.week4;

import java.util.PriorityQueue;

/**
 * @author Baurzhan Alzhanov
 * @date on 03.03.2021
 */


public class FindKthLargest {

    public static void main(String[] main) {
        int[] test = {3, 2, 1, 5, 6, 4};
        System.out.println(Solution.findKthLargest(test, 2));
    }


    static class Solution {
        public static int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);
            for (int num : nums) {
                largeK.add(num);
                if (largeK.size() > k) {
                    largeK.poll();
                }
            }

            return largeK.peek();
        }
    }
}
