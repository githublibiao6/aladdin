package com.aladdin.mis.algo;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯排序
 */
public class Hs {
    // 每个数字到字母的映射
    static String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    static List<String> result = new LinkedList<>();;
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        letterCombinations("12");
    }

    private static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }

        backtrack(digits, 0);
        return result;
    }

    //回溯算法
    private  static void backtrack(String digits, int start){
        if (str.length() == digits.length()) {
            result.add(str.toString());
            return;
        }

        int digit = digits.charAt(start) - '0';
        for (char c : mapping[digit].toCharArray()) {
            //做选择
            str.append(c);
            //递归到下一层
            backtrack(digits, start + 1);
            //撤销选择
            str.deleteCharAt(str.length() - 1);
        }
    }
}
