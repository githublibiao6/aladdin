package com.aladdin.mis.Leetcode;

/**
 * 有效括号
 */
public class Solution28 {

    public static void main(String[] args) {
        String needle= "aaaa";
        String haystack = "aaa";
        System.out.println(strStr(haystack, needle));

    }


    private static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                for (int j = 0; j < needle.length(); j++) {
                    if(i+j >= haystack.length()){
                        return -1;
                    }
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        break;
                    }
                    if(j == needle.length() -1){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private static int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}