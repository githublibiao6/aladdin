package com.aladdin.mis.Leetcode;

/**
 * x的平方根
 */
public class Solution69 {

    public static void main(String[] args) {
        int data = mySqrt(4);
        System.out.println(data);

    }


    private static int mySqrt(int x)  {
        if(x == 1){
            return 1;
        }
        return mySqrt(x ,0, x);
    }

    private static int mySqrt(int x, long left, long right)  {
        if(right > (1 << 16)){
            return mySqrt(x, 0 , 1 << 16 );
        }
        long m = (left + right)/2;
        if(m * m > x){
            if((m-1) * (m-1) < x){
                return (int)m-1;
            }
            return mySqrt(x, left, m);

        }else if(m * m < x){
            if((m+1) * (m+1) > x ){
                return (int)m;
            }

            return mySqrt(x, m, right);
        }else {
            return (int)m;
        }
    }


}
