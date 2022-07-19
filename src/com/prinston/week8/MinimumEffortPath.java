package com.prinston.week8;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Baurzhan Alzhanov
 * @date on 09.04.2021
 */


public class MinimumEffortPath {
    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }
    public  static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int [][] dir = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int [][] effort = new int [m][n];

        for (int i=0; i<m; i++){
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        // dist, row, colomn
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int []{0, 0, 0});

        while(!pq.isEmpty()){
            int[] min = pq.poll();
            int dist = min[0], row = min[1], col = min[2];
            if(dist > effort[row][col]) continue;
            if(row == m-1 && col == n-1) return dist;
            for(int[] d : dir){
                int newRow = row+d[0];
                int newCol = col+d[1];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newDist = Math.max(dist, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if(newDist < effort[newRow][newCol]){
                        effort[newRow][newCol] = newDist;
                        pq.offer(new int[]{newDist, newRow, newCol});
                    }
                }
            }
        }
        return -1;
    }
}
