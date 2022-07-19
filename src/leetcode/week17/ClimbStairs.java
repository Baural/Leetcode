package leetcode.week17;

/**
 * @author Baurzhan Alzhanov
 * @date on 03.05.2022
 */


public class ClimbStairs {
    public static void main(String[]args){
        ClimbStairs cs = new ClimbStairs();
        System.out.println(cs.climbStairs(6));
    }
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}

