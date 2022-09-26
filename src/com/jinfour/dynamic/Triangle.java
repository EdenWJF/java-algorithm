package com.jinfour.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> line1 = Arrays.asList(2);
        List<Integer> line2 = Arrays.asList(3,4);
        List<Integer> line3 = Arrays.asList(6,5,7);
        List<Integer> line4 = Arrays.asList(4,1,8,3);
        triangle.add(line1);
        triangle.add(line2);
        triangle.add(line3);
        triangle.add(line4);
        System.out.println(t.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() < 2) {
            return triangle.get(0).get(0);
        }
        return minimumTotalInternal(triangle);
    }

    public int minimumTotalInternal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len+1][len]; // dp[i] 以i为顶点的最小路径和
        dp[0][0] = 0;

        for(int i = 1; i <= len; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i-1).get(0);
            for(int j = 1; j < i; j++) {
                if (j == i - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i-1).get(j);
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i-1).get(j);
                }
            }
        }
        int min = dp[len][0];
        for(int i = 1; i < len; i++) {
            min = Math.min(min, dp[len][i]);
        }
        return min;
    }
}
