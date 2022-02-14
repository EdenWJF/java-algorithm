package com.jinfour.dynamic;

public class SubSequence {


    public static void main(String[] args) {
        System.out.println(getLongestPalindromeSubseq("asssasms"));
        System.out.println(getLongestCommonSubsequence("abcde", "ade"));
    }

    static int getLongestPalindromeSubseq(String s) {
        int n = s.length();
        if (0 == n) return 0;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    static int getLongestCommonSubsequence(String text1, String text2) {

        if (text1.length() == 0 || text2.length() == 0) return 0;
        int n = text1.length(),m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    static int getLongest(String text) {
        int len = text.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (j - i < 2) {
                    if (text.charAt(i) == text.charAt(j)) dp[i][j] = 2;
                }else {
                    if (text.charAt(i) == text.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}
