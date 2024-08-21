package com.aladdin.mis.learn.leetcode;

/**
 * 两数相除
 * @author libia
 */
public class Solution29 {

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 2;
        int result = divide(dividend, divisor);
        System.out.println(result);

    }

    /**
     * nice
     * @param a
     * @param b
     * @return
     */
    private static int divide(int a, int b) {
        long dividend = a;
        long divisor = b;
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return a;
        }
        int result = 0;
        boolean flag = true;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0){
            flag = false;
        }
        if(dividend < 0){
            dividend = - dividend;
        }
        if(divisor < 0){
            divisor = - divisor;
        }
        int i = 30;
        while (i > -1){
            if(dividend >= divisor << i){
                dividend -= divisor << i;
                result += (1 << i);
            }
            i--;
        }
        return flag ? result : - result;
    }

    /**
     * 超时
     * @param a 被除数
     * @param b 除数
     * @return int
     */
    private static int divide2(int a, int b) {
        System.err.println(10<<b);
        long dividend = a;
        long divisor = b;
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return a;
        }
        int result = 0;
        if(dividend > 0 && divisor > 0){
            while (dividend > 0 && dividend >= divisor){
                result ++;
                dividend -= divisor;
                if(result == Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }
            return result;
        }
        if(dividend < 0 && divisor < 0){
            while (dividend < 0 && dividend <= divisor){
                result ++;
                dividend -= divisor;
                if(result == Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }
            return result;
        }
        if(dividend < 0){
            System.err.println(Math.abs(dividend));
            while (dividend < 0 && Math.abs(dividend) >= divisor){
                result --;
                dividend += divisor;
                if(result == Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
            return result;
        }
        while (dividend > 0 && dividend >= Math.abs(divisor)){
            result --;
            dividend += divisor;
            if(result == Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return result;
    }
}
