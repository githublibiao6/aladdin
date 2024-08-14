package com.aladdin.mis.learn.leetcode;

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
public class LongS {

    public static void main(String[] args) {
//        String s = "askjdlksajdkjsakdsajdlksajdlksa";
        String s = "wwwwwwwke";
//        String s = "pwwwwwwke";
        int m = lengthOfLongestSubstring2(s);
        System.err.println(m);
    }


    private static int lengthOfLongestSubstring_1(String s) {
        char[] array = s.toCharArray();
        if(array.length == 1){
            return 1;
        }
        int start = 0;
        int end = 1;
        int length = 0;
        while (end < array.length){
            String str = s.substring(start, end);
            if(str.indexOf(array[end]) != -1){
                start ++;
            }else {
                end ++;
            }
            length = Math.max(end-start, length);
        }
        return length;
    }

    private static int lengthOfLongestSubstring2(String s) {
        int left = 0, length = 0, max = 0;
        for(int right=0; right < s.length(); right++){
            for(int k = left; k < right; k++){
                if(s.charAt(k) == s.charAt(right)){
                    left = k+1;
                    length = right-left;
                    break;
                }
            }
            length++;
            if(max < length) max = length;
        }
        return max;
    }
}
