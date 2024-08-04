package com.aladdin.mis.Leetcode;

import java.util.Stack;

/**
 * 有效括号
 */
public class Solution20 {

    public static void main(String[] args) {
        String s = "(())";
        boolean flag = isValid(s);
        System.out.println(flag);

    }

    /**
     * list -> stack
     * @param s
     * @return
     */
    private static boolean isValid(String s) {
        if(s == null || s.length()%2 == 1){
            return false;
        }
        Stack<Character> list = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) == '('){
                list.add(')');
            }else if(s.charAt(i) == '['){
                list.add(']');
            }else if(s.charAt(i) == '{'){
                list.add('}');
            }else {
                if(!list.isEmpty() && list.peek() == s.charAt(i)){
                    list.pop();
                }else {
                    return false;
                }
            }
        }
        return list.size() <= 0;
    }

}
