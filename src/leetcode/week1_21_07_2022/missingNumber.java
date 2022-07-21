package leetcode.week1_21_07_2022;

import java.util.Arrays;

/**
 * @author baur
 * @date on 21.07.2022
 */


public class missingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        if (nums[0] != 0){
            result = 0;
        } else if (nums.length-1 < 1) {
            result = nums[nums.length-1]+1;
        } else {
            for (int i = 0; i < nums.length-1; i++){
                if (nums[i+1] - nums[i] == 2){
                    result = nums[i]+1;
                    return result;
                }
                else {
                    result = nums[nums.length-1]+1;
                }
            }
        }

        return result;

    }
}

