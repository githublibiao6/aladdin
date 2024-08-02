package com.aladdin.mis.algo;

/**
 * 动态规划
 */
public class Dp {
    /**
     * 0-1背包问题
     * @param args
     */
    public static void main(String[] args) {
        int[] wgt = new int[]{3,1,2,2,1};
        int[] val = new int[]{8,1,5,5,1};
        int cap = 4;
        int  result = knapsackDPComp(wgt, val, cap);
        System.err.println(result);
    }

    public  static  int knapsackDPComp(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        // 初始化 dp 表
        int[] dp = new int[cap + 1];
        // 状态转移
        for (int i = 1; i <= n; i++) {
            int index = i-1;
            int w = wgt[index];
            int v = val[index];
            // 倒序遍历
            for (int c = cap; c >= 1; c--) {
                System.err.println("-----");
                if (w <= c) {
                    // 不选和选物品 i 这两种方案的较大值
                    int planA = dp[c];
                    int planB = dp[c - w] + v;
                    dp[c] = Math.max(planA, planB);
                }
            }
        }
        for (int value : dp) {
            System.err.println(value);
        }
        System.err.println(cap);
        return dp[cap];
    }
}
/*
0
1
5
8
10
4
10
*/
