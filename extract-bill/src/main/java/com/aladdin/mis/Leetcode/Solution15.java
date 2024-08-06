package com.aladdin.mis.Leetcode;

import java.util.*;

/**
 * 有效括号
 */
public class Solution15 {

    public static void main(String[] args) {
        int[] num = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> s1 = threeSum(num);
        System.out.println(s1);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> data = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j <  nums.length; j++) {
                if(set.contains(nums[j])){
                    continue;
                }
                int sum = nums[i] + nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    if(set.contains(nums[k])){
                        continue;
                    }
                    if(sum + nums[k] == 0){
                        set.add(nums[j]);
                        set.add(nums[k]);

                        List<Integer> m = new ArrayList<>();
                        m.add(nums[i]);
                        m.add(nums[j]);
                        m.add(nums[k]);
                        data.add(m);
                        break;
                    }
                }
            }
        }
        return data;
    }
}

