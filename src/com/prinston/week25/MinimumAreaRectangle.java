package com.prinston.week25;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Baurzhan Alzhanov
 * @date on 10.08.2021
 */


public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points){
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int p[]: points) {
            if(!map.containsKey(p[0])){
                map.put(p[0], new HashSet<Integer>());
            }
            map.get(p[0]).add(p[1]);
        }
        int minimumArea = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                if(x1 != x2 && y1 != y2){
                    if(map.get(x1).contains(y2) && map.get(x2).contains(y1)){
                        minimumArea = Math.min(minimumArea, Math.abs(x1-x2)* Math.abs(y1-y2));
                    }
                }
            }
        }
        return minimumArea != Integer.MAX_VALUE ? minimumArea : 0;
    }

    public static void main(String[] args) {
        MinimumAreaRectangle mar = new MinimumAreaRectangle();
        int [][] points = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};

        int result = mar.minAreaRect(points);
        System.out.println(result);
    }
}
