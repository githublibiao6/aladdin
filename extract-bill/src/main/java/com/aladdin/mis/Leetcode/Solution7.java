package com.aladdin.mis.Leetcode;

import java.util.Stack;

/**
 * 整数反转
 */
public class Solution7 {

    public static void main(String[] args) {
        int s = 123;
        int s1 = reverse(s);
        System.out.println(s1);
    }


    private static int reverse(int x) {
        String str = String.valueOf(x);
        char[] array = str.toCharArray();
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;
        for (char c :array){
            int m = c - '0';
            if(m < 0){
                flag = false;
            }else {
                stack.push(m);
            }
        }
        long num = 0;
        while (!stack.isEmpty()){
            int m = stack.pop();
            num += m * Math.pow(10, stack.size());
            if(flag && num > Integer.MAX_VALUE){
                return 0;
            }
            if(!flag && -num < Integer.MIN_VALUE){
                return 0;
            }
        }
        return flag ? (int)num : -(int)num;
    }


}
