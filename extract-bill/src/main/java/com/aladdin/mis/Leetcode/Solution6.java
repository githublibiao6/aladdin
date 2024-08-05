package com.aladdin.mis.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效括号
 */
public class Solution6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int value = 4;
        String s1 = convert(s, value);
        System.out.println(s1);
    }

    private static String convert(String s, int numRows) {
        Map<Integer, StringBuilder> map = new HashMap<>(16);
        int j = 0;
        boolean flag = true;
        for (int i = 0; i < s.length() - 1 ; i++) {
            String c = s.substring(i, i+1);
            if(map.containsKey(j)){
                map.put(j, map.get(j).append(c));
            }else {
                map.put(j, new StringBuilder(c));
            }
            if(flag){
                j++;
            }else {
                j --;
            }
            if(j == numRows){
                j --;
                flag = false;
            }
            if(j < 0){
                j = 1;
                flag = true;
            }
        }
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            data.append(map.get(i));
        }
        return data.toString();
    }
}

