package com.aladdin.mis.Leetcode;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class InsertTarget {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,5,6};
//        int target = 7;
//        int m = searchInsert(nums, target);
//        System.err.println(m);

        String s = "l";
        int m = lengthOfLastWord(s);
        System.err.println(m);
    }


    private static int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private static int search(int[] array, int num, int start, int end) {
        if(start > end){
            return start;
        }
        int mid = (start + end)/2;
        if(array[mid] == num){
            return mid;
        }else if(array[mid] > num){
            return search(array, num, 0, mid-1);
        }else if(array[mid] < num) {
            return search(array, num, mid + 1 , end);
        }
        return -1;
    }

    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1 ; i >= 0; i--) {
            if(s.charAt(i) != ' '){
                length ++;
            }
            if(s.charAt(i) == ' ' && length > 0){
                break;
            }
        }
        return length;
    }

    public static int lengthOfLastWord_1(String s) {
        String[] array = s.split(" ");
        return array[array.length - 1].length();
    }

}
