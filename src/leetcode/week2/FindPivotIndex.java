package leetcode.week2;

/**
 * @author baur
 * @date on 26.07.2022
 */


public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int left = 0, right = 0, sum = 0;
        for (int n : nums){
            sum += n;
        }

        for (int i =0; i < nums.length; i++){
            right = sum - nums[i] - left;

            if (left == right){
                return i;
            }
            left += nums[i];
        }
        return -1;

    }
}
