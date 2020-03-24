package com.jinfour.dynamic;

import java.util.Arrays;
import java.util.List;

public class Leetcode_120 {

    /**
     * 三角形路径之和
     *
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     *
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     */

    public static void main(String[] args){
        List<Integer> row1 = Arrays.asList(2);
        List<Integer> row2 = Arrays.asList(3,4);
        List<Integer> row3 = Arrays.asList(2,5,7);
        List<Integer> row4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> triangle = Arrays.asList(row1, row2, row3, row4);
        int i = minimumTotal(triangle);
        System.out.println(i);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i+1][j+1]) + row.get(j);
            }
        }
        return dp[0][0];

    }
}
