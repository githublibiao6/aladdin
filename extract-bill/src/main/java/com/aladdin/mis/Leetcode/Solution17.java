package com.aladdin.mis.Leetcode;

import java.util.*;

/**
 * 电话号码的组合
 */
public class Solution17 {

    public static void main(String[] args) {
        String s = "23";
        List<String> s1 = letterCombinations(s);
        int n = 'a' ;
        int m = '2' + 47 ;
        System.out.println("---------pp"+s1);
    }



    /**
     * 5%
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> data = new ArrayList<>();
        if(digits.length() == 0){
            return data;
        }
        for (int i = 0; i < digits.length(); i++) {
            List<String> s = getLetters(Integer.parseInt(digits.substring(i, i + 1)));
            if(data.isEmpty()){
                data.addAll(s);
            }else {
                List<String> old = new ArrayList<>(data);
                data.clear();
                for(String o : old){
                    for (String value : s) {
                        data.add(o + value);
                    }
                }
            }
        }
        return data;
    }

    private static List<String> getLetters(int num){
        List<String> data = new ArrayList<>();
        int size = 3;
        int plus = 0;
        if(num == 9 || num == 7){
            size = 4;
        }
        if(num == 8 || num == 9){
            plus = 1;
        }
        for (int i = 0; i < size; i++) {
            String m = String.valueOf((char)('a' + (num -2) * 3  + i + plus));
            data.add(m);
        }
        return data;
    }
}

