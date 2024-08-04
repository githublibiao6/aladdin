package com.aladdin.mis.Leetcode;

/**
 * 有效括号
 */
public class Solution5 {

    public static void main(String[] args) {
        String s = "bb";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }


    private static String longestPalindrome(String s) {

        int start = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLength(s , i , i);
            int len2 = getLength(s , i , i+1);
            int len = Math.max(len1, len2);
            if(len > length){
                start = len1 > len2 ? i - len/2 : i - len/2 + 1;
                length = len;
            }
        }
        length = Math.max(length, 1);
        return s.substring(start, start+length);
    }

    private static int getLength(String s, int left, int right) {
        int length = 0;
        if(left == right){
            length = 1;
            left --;
            right ++;
        }
        while (left >-1  && right < s.length() && s.charAt(left) == s.charAt(right)){
            length += 2;
            left --;
            right ++;
        }
        return length;
    }

    private static String longestPalindrome2(String s) {
        if(s.length() == 1){
            return s;
        }
        int start = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() -1 ; j >= 0 ; j--) {
                if(s.charAt(i) == s.charAt(j) && i < j){
                    int left = i, right = j;
                    while (s.charAt(left) == s.charAt(right)){
                        if(left == right || left == right -1){
                            break;
                        }
                        left ++;
                        right --;
                    }
                    if(left == right){
                        if(j - i + 1 > length ){
                            length =  j - i + 1;
                            start = i;
                        }
                    }
                    if(left == right -1 && s.charAt(left) == s.charAt(right)){
                        if(j - i + 1 > length ){
                            length =  j - i + 1;
                            start = i;
                        }
                    }
                }
            }
        }
        if(length == 0){
            return s.substring(0, 1);
        }
        return s.substring(start, start + length);
    }

}
