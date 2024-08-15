package com.aladdin.mis.learn.leetcode;

/**
 * 盛水最多的容器
 *
 * 双指针
 */
public class Solution11 {

    public static void main(String[] args) {
        int[] val = new int[]{2,3,4,5,18,17,6};
        int max = maxArea(val);
        System.err.println(max);

    }

    private static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length -1 ;

        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left ++;
            }else {
                right --;
            }
        }
        return max;
    }

    private static int maxArea1(int[] height) {
        int max = 0;
        int minHeight = -1;

        for (int i = 0; i < height.length; i++) {
            if(height[i] < minHeight){
                continue;
            }
            for (int j = height.length -1 ; j > i; j--) {
                if(height[j] < minHeight){
                    continue;
                }
                minHeight = Math.min(height[i], height[j]);
                max = Math.max(max, minHeight * Math.abs((j -i)));
            }
        }
        return max;
    }

    private static int maxArea2(int[] height) {
        int maxAre = 0;
        int left = 0;
        int right = height.length - 1;
        // 只是坐标大小，并不是对应坐标的高度
        while (left < right) {
            maxAre = Math.max(maxAre, (right - left) * Math.min(height[left], height[right]));
            // 矮的柱子往中间靠
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxAre;
    }



}
