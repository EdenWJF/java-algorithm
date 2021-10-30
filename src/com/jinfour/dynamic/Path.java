package com.jinfour.dynamic;

import java.util.Arrays;

public class Path {

    // 路径规划问题

    public static void main(String[] args) {
        System.out.println(getPathCount(3, 3));
        int[][] arr = new int[3][3];
        arr[0][1] = 1;
        System.out.println(getPathCountWithBarrier(arr));
    }

    static int getPathCount(int m, int n) {
        int[][] dp = new int[m][n];

        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    static int getPathCountWithBarrier(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        int n = arr.length;
        int m = arr[0].length;
        if (arr[0][0] == 1) return 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 1) {
                dp[i][0] = 0;
                break;
            }else {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            if (arr[0][i] == 1) {
                dp[0][i] = 0;
                break;
            }else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 1) {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
