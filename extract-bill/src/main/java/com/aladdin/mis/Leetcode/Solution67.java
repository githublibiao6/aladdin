package com.aladdin.mis.Leetcode;

import java.util.Stack;

/**
 * 二进制求和
 */
public class Solution67 {

    public static void main(String[] args) {
        String s = "1010";
        String m = "1011";
        String data = addBinary(s, m);
//        int a = s.charAt(0);
//        System.out.println(a);
        System.out.println(data);

    }


    private static String addBinary(String a, String b) {

        int m = 0;
        int lena = a.length();
        int lenb = b.length();
        Stack<String> stack = new Stack<>();
        int len = Math.max(lena, lenb);
        for (int i = 0; i < len; i++) {
            char numa = '0' ;
            char numb = '0';
            if(lena > 0){
                numa = a.charAt(lena-1);
            }
            if(lenb > 0){
                numb = b.charAt(lenb-1);
            }
            if(numa == '1' && numb == '1'){
                if(m == 1){
                    stack.push("1");
                }else {
                    stack.push("0");
                }
                m = 1;
            }else if(numa == '0' && numb == '0'){
                if(m == 1){
                    stack.push("1");
                }else {
                    stack.push("0");
                }
                m = 0;
            }else {
                if(m == 1){
                    stack.push("0");
                    m = 1;
                }else {
                    stack.push("1");
                    m = 0;
                }
            }
            lena --;
            lenb --;
        }
        if(m == 1){
            stack.push("1");
        }
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()){
            s.append(stack.pop());
        }
        return s.toString();
    }


}
