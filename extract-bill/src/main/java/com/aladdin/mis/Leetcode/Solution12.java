package com.aladdin.mis.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效括号
 */
public class Solution12 {

    public static void main(String[] args) {
        int value = 3749;
        String s1 = intToRoman(value);
        System.out.println(s1);
    }

    private static String intToRoman(int num) {
        StringBuilder data = new StringBuilder();
        if(num / 1000 > 0){
            data.append(getNum(num / 1000, "M","", ""));
            num = num % 1000;
        }
        if(num / 100 > 0){
            data.append(getNum(num / 100, "C","D", "M"));
            num = num % 100;
        }
        if(num / 10 > 0){
            data.append(getNum(num / 10, "X","L", "C"));
            num = num % 10;
        }

        data.append(getNum(num, "I","V", "X"));
        return data.toString();
    }

    private static String getNum(int num, String left, String mid, String right) {
        StringBuilder data = new StringBuilder();
        if(num == 9){
            data.append(left).append(right);
        }else if(9 > num && num > 5) {
            data.append(mid);
            for (int i = 0; i < num - 5; i++) {
                data.append(left);
            }
        }else if(num == 5 ) {
            data.append(mid);
        }else if(num == 4 ) {
            data.append(left).append(mid);
        }else {
            for (int i = 0; i < num ; i++) {
                data.append(left);
            }
        }
        return data.toString();
    }
}

