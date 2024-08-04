package com.aladdin.mis.Leetcode;

/**
 * 有效括号
 */
public class Solution283 {

    public static void main(String[] args) {
        int[] val = new int[]{0,8,0,1,5,5,1,0};
        moveZeroes(val);
        for (int n : val){
            System.out.print(n + ",");
        }

    }


    private static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[index] = nums[i];
                index ++;
            }
        }
        for (int i = 0; i < nums.length - index; i++) {
            nums[nums.length -1 - i] = 0;
        }
    }

}
