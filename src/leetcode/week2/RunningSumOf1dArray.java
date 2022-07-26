package leetcode.week2;

/**
 * @author baur
 * @date on 26.07.2022
 */


public class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int[] newNum = new int[nums.length];
        int sum = 0;
        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
            newNum[i] = sum;
        }
        return newNum;
    }
}
