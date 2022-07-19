package com.prinston.week15;

import java.util.*;

/**
 * @author Baurzhan Alzhanov
 * @date on 24.05.2021
 */


public class TopKFrequentElements {
//    public static void main(String[] args) {
//        TopKFrequent tp = new TopKFrequent();
//        int b = 4;
//        int[] dil = new int[] {1,1,1,2,2,3};
//        System.out.println(tp.topKFrequent(dil, b));
//    }

    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) +1);
        }
        Queue<Integer> pq = new PriorityQueue<>((num1, num2) -> map.get(num2)- map.get(num1));

        for (int num:  map.keySet()) {
            pq.add(num);
            if (pq.size()> k) pq.poll();
        }

        for (int i = k - 1; i > 0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }
}
