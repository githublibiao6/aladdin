package com.aladdin.mis.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 有效括号
 */
public class Solution22 {

    public static void main(String[] args) {
        int n = 2;
        List<String> s1 = generateParenthesis(n);
        System.out.println(s1);
    }
    static List<String> result = new LinkedList<>();;
    static StringBuilder str = new StringBuilder();
    static Stack<String> stack = new Stack<>();
    static String[] map = new String[]{"(", ")"};

    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        getGroup(0, n , true,  stack, result, new StringBuilder());
        return result;
    }

    private static void getGroup(int start, int n, boolean flag, Stack<Integer> stack, List<String> result, StringBuilder str) {
        if(start > n){
            return;
        }
        if (start == n && stack.isEmpty()) {
            result.add(str.toString());
            return;
        }
        if(flag){
            str.append("(");
            stack.push(1);
        }else if(!stack.isEmpty()){
            str.append(")");
            stack.pop();
        }
        start ++;
        getGroup(start, n , true,  stack, result, str);
        getGroup(start, n , false,  stack, result, str);
    }

}
