package com.prinston.week15;

import java.util.Arrays;

/**
 * @author Baurzhan Alzhanov
 * @date on 24.05.2021
 */


public class MaxArea {
    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        int x = 5, y = 4;
        int[] hoti = {1,2,4};
        int[] vert = {1,3};
        System.out.println(ma.maxArea(x, y, hoti, vert));
    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int n = horizontalCuts.length;
        int m = verticalCuts.length;

        int maxHeight = Math.max(horizontalCuts[0], h -horizontalCuts[n -1]);
        for (int i = 1; i < n; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1 ]);
        }

        int maxWidth = Math.max(verticalCuts[0], w -verticalCuts[m -1]);
        for (int i = 1; i < m; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1 ]);
        }
        long ans = 1L * maxHeight * maxWidth;

        return  (int) (ans % 1000000007);
    }
}
