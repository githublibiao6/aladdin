package com.aladdin.mis.Leetcode;

/**
 * 字符串转整数
 */
public class Solution8 {

    public static void main(String[] args) {
        String s = "+-12";
        int s1 = myAtoi(s);
        System.out.println(s1);
    }


    private static int myAtoi(String s) {
        long num = 0;
        boolean flag = false;
        boolean plus = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && !flag){
                continue;
            }
            if (s.charAt(i) == '-' && !flag){
                plus = false;
                flag = true;
                continue;
            }
            if (s.charAt(i) == '+' && !flag){
                flag = true;
                continue;
            }
            if(!isNumber(s.charAt(i))){
                if(flag){
                    break;
                }else {
                    return 0;
                }
            }
            if(isNumber(s.charAt(i))){
                flag = true;
                if(plus){
                    num = num * 10 + (s.charAt(i) - '0');
                    if(num >= Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }else {
                    num = num * 10 - (s.charAt(i) - '0');
                    if(num <= Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }
            }
        }
        return  (int)num;
    }

    private static boolean isNumber(Character character) {
        return 0 <= character - '0' && character - '0' <= 9;
    }


}
