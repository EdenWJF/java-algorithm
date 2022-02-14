package com.jinfour.dynamic;

public class SubArray {

    /**
     * 子数组问题
     */

    public static void main(String[] args) {

        System.out.println(countSubStrings("aaabbb"));

    }

    static int countSubStrings(String s) {

        int n = s.length();
        if (n == 0) return 0;

        boolean[][] dp = new boolean[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            sum++;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
