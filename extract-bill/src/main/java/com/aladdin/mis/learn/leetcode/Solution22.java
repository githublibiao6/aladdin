package com.aladdin.mis.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效括号
 */
public class Solution22 {

    public static void main(String[] args) {
        int n = 3;
        List<String> s1 = generateParenthesis(n);
        System.out.println(s1);


    }

    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getGroup( 0, 0,  n , true, result, "");
        return result;

        // 最优解
//        List<String> res = new ArrayList<>();
//        dfs(0,0,n,new StringBuilder(),res);
//        return res;
    }

    private static void getGroup(int left, int right ,int n, boolean flag, List<String> result, String str) {
        if(str.length() > n*2){
            return;
        }
        if (right == n && left < n) {
            return;
        }
        if(flag){
            str += "(";
            left ++;
        }else if(right < n){
            str +=  ")";
            right ++;
        }
        if (str.length() == n*2 && left == n && right == n) {
            result.add(str);
            return;
        }
        if (left > n || right > left) {
            return;
        }
        getGroup(left, right , n , true,  result, str);
        getGroup(left, right , n , false,  result, str);
    }



    private void dfs(int left, int right,int n ,StringBuilder path,List<String> res){
        if(path.length() == 2*n) {
            res.add(path.toString());
        }
        if(left < n){
            path.append('(');
            dfs(left+1,right,n,path,res);
            path.deleteCharAt(path.length()-1);
        }
        if(right<left){
            path.append(')');
            dfs(left,right+1,n,path,res);
            path.deleteCharAt(path.length()-1);
        }
    }

}
