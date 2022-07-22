package leetcode.week1_22_07_2022;

/**
 * @author baur
 * @date on 23.07.2022
 */


public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int j = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                temp[j] = nums[i];
                j++;
            }
        }

        for(int i =0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }
}
