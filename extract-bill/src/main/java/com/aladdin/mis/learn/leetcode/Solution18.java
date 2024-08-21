package com.aladdin.mis.learn.leetcode;

import java.util.*;

/**
 * 四数之和
 */
public class Solution18 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        int target = -11 ;
//        ks(nums, 0 ,nums.length -1);
        for (int s : nums){
            System.err.print(s +",");
        }
        System.err.println();
        List<List<Integer>> s1 = fourSum(nums, target);
        System.out.println(s1);
    }

    /**
     * 5%
     * @param nums
     * @return
     */ // [-9,-7,-2,5],
    // [[-10,-9,-4,10],[-10,-9,2,4],[-9,-9,-4,9],[-9,-7,-2,5],[-9,-4,-2,2],[-7,-2,-2,-2]]
    // [[-10,-9,-4,10],[-10,-9,2,4],[-9,-9,-4,9],[-9,-7,-2,5],[-9,-7,-2,5],[-9,-4,-2,2],[-7,-2,-2,-2]]
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> data = new ArrayList<>();
        if(nums.length < 4 ){
            return data;
        }

        ks(nums, 0 ,nums.length -1);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 && target < 0){
                return data;
            }
            if (i > 0 && nums[i - 1] == nums[i] ){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j] ){
                    continue;
                }
                int m = j + 1;
                int n = nums.length -1;
                while (m < n ){
                    long sum = (long) nums[i] + nums[j] + nums[m] + nums[n];
                    if(sum < target){
                        m ++;
                        continue;
                    }
                    if(sum > target){
                        n --;
                        continue;
                    }
                    List<Integer> d = new ArrayList<>();
                    d.add(nums[i]);
                    d.add(nums[j]);
                    d.add(nums[m]);
                    d.add(nums[n]);
                    data.add(d);
                    while(m < n &&nums[m] == nums[m+1]){
                        m ++;
                    }
                    while(m < n && nums[n] == nums[n-1]){
                        n --;
                    }
                    m ++;
                    n --;
                }
            }
        }
        return data;
    }

    private static void ks(int[] array, int begin , int over) {
        int start = begin;
        int end = over;
        if(start >= end){
            return;
        }
        int num = array[start];
        while (start < end){
            while (start < end && num <= array[end]){
                end --;
            }
            while (start < end && num >= array[start]){
                start ++;
            }
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        // 基数替换到指定位置
        array[begin] = array[end];
        array[end] = num;
        // 快速左侧
        ks(array, begin, end - 1);
        // 快速右侧
        ks(array, end + 1, over);
    }
}

