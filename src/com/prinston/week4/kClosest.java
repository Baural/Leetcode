package com.prinston.week4;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Baurzhan Alzhanov
 * @date on 03.03.2021
 */


public class kClosest {
    public static void main(String[] main) {
        Solution solution = new Solution();
        int[][] test = {{3,3},{5,-1},{-2,4}};
        int [][]res=solution.kClosest(test,2);
        for (int []s:res
        ) {
            System.out.println(Arrays.toString(s));

        }
    }

    static class Solution {
        public static int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
            int[][] result = new int[K][2];
            int index=0;
            for(int[] arr:points) {
                maxHeap.add(arr);
            }
            while(index<K) {
                result[index]=maxHeap.poll();
                index++;
            }
            return result;
        }
    }
}
