package com.prinston.week23;

/**
 * @author Baurzhan Alzhanov
 * @date on 23.07.2021
 */


public class MinimumDeletionCost {
    public int minCost(String s, int[] cost) {
        int result = 0, previus = 0;
        char[] ch = s.toCharArray();
        for (int i = 1; i < s.length(); ++i) {
            if (ch[previus] != ch[i]) {
                previus = i;
            } else {
                result += Math.min(cost[previus], cost[i]);
                if (cost[previus] < cost[i]){
                    previus = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumDeletionCost mdc = new MinimumDeletionCost();
        int[] newCost = {1,2,3,4,1};
        String str = "aabaa";
        int res = mdc.minCost(str, newCost);
        System.out.println(res);
    }
}
