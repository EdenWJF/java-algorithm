package com.jinfour.dynamic;

import java.util.Arrays;
import java.util.Map;

public class Packet_0_1 {

    /**
     * 0 1背包问题
     */
    public static void main(String[] args) {
        int[] w = {5,2,3};
        int[] n = {6,3,4};
        int N = 3;
        int W = 9;

        System.out.println(getAnswer2(W,N,w,n));
    }

    /**
     *
     * @param W 背包总重量
     * @param N 背包总物品量
     * @param w 物品重量
     * @param n 物品价值
     * @return 最大价值
     */
    static int getAnswer(int W, int N, int[] w, int[] n) {

        int[][] dp = new int[W+1][N+1]; // 在某重量、前n个物品下，最大价值

        for (int i = 0; i < W+1; i++) { // 初始化，物品数量为0，最大价值也是0
            dp[i][0] = 0;
        }
        for (int i = 0; i < N+1; i++) { // 初始化，重量控制为0，最大价值亦为0
            dp[0][i] = 0;
        }

        for (int i = 1; i <= N; i++) { // 逐个增加物品数量
            for (int j = 1; j <= W; j++) { // 逐步增加重量
                if (w[i-1] > j) {
                    dp[j][i] = dp[j][i-1];
                }else {
                    int rest = j - w[i-1];
                    dp[j][i] = Math.max(dp[rest][i-1] + n[i-1], dp[j][i-1]);
                }
            }
        }
        return dp[W][N];
    }


    static int getAnswer2(int W, int N, int[] w, int[] n) {
        int[][] dp = new int[W+1][N+1]; // 在某重量、前n个物品下，最大价值

        for (int i = 0; i < W+1; i++) { // 初始化，物品数量为0，最大价值也是0
            dp[i][0] = 0;
        }
        for (int i = 0; i < N+1; i++) { // 初始化，重量控制为0，最大价值亦为0
            dp[0][i] = 0;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (w[i-1] > j) {
                    dp[j][i] = dp[j][i-1];
                }else {
                    int count = j / w[i-1];
                    int max = dp[j][i-1];
                    for (int k = 1; k < count+1; k++) {
                        int rest = j - w[i-1] * k;
                        max = Math.max(max, dp[rest][i-1] + n[i-1] * k);
                    }
                    dp[j][i] = max;
                }
            }
        }
        return dp[W][N];

    }
}
