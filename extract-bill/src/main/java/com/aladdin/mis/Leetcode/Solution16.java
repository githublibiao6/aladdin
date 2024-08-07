package com.aladdin.mis.Leetcode;

import java.util.*;

/**
 * 有效括号
 */
public class Solution16 {

    public static void main(String[] args) {
        int[] num = new int[]{-1,2,1,-4};
        int target = 1;
        int s1 = threeSumClosest(num, target);
        System.out.println("---------pp"+s1);
    }
// [[-1, 0, 1], [1, 2, -3], [2, -2, 0], [-1, -2, 3], [-1, -3, 4], [-4, 0, 4], [-3, 3, 0]
// [[-1, 0, 1],             [2, -2, 0], [-1, -2, 3],              [-4, 0, 4], [-3, 3, 0]]

    /**
     * 5%
     * @param nums
     * @return
     */
    private static int threeSumClosest(int[] nums ,int target) {
        ks(nums, 0 ,nums.length -1);
        int data = 0;
        int min = Integer.MAX_VALUE;
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            int k = nums.length -1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                System.out.println(sum);
                int temp ;
                // 计算差值
                if(sum > 0){
                    temp = Math.abs(target - sum);
                }else {
                    temp = Math.abs(sum - target);
                }
                System.err.println(temp);
                if(min > temp){
                    data = sum;
                    min = temp;
                }
                if(sum < target){
                    j ++;
                }else if(sum > target) {
                    k--;
                }else {
                    return sum;
                }
            }
            i++;
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

    private static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> data = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>(16);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <  nums.length; j++) {
                List<Integer> set = map.get(nums[i]);
                if(set != null && set.contains(nums[j])){
                    continue;
                }
                int sum = nums[i] + nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    set = map.get(nums[i]);
                    if(set != null && set.contains(nums[k])){
                        continue;
                    }
                    if(sum + nums[k] == 0){

                        handleMap(nums[i], nums[j], nums[k], map);
                        handleMap(nums[j], nums[i], nums[k], map);
                        handleMap(nums[k], nums[j], nums[i], map);

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

    private static void handleMap(int i, int j, int k, Map<Integer, List<Integer>> map){
        if(map.containsKey(i)){
            List<Integer> set = map.get(i);
            set.add(j);
            set.add(k);
            map.put(i, set);
        }else {
            List<Integer> set = new ArrayList<>();
            set.add(j);
            set.add(k);
            map.put(i, set);
        }

    }
}

