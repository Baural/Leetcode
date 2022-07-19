package com.prinston.week23;

/**
 * @author Baurzhan Alzhanov
 * @date on 21.07.2021
 */


public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        MaxProfit mp = new MaxProfit();
        int result = mp.maxProfit(prices);
        System.out.println(result);
    }
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }
}
