package com.jinfour.dynamic;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode.cn/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (61.31%)
 * Likes:    3580
 * Dislikes: 0
 * Total Accepted:    515.7K
 * Total Submissions: 840.4K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 *
 * 示例 2：
 *
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 *
 *
 * 提示：
 *
 *
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 *
 *
 */
public class Trapping_rain_water {

    public static void main(String[] args) {
        com.jinfour.doublepointer.Trapping_rain_water solution = new com.jinfour.doublepointer.Trapping_rain_water();
        int sum = solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(sum);
    }

    public int trap(int[] height) {
        return method1(height);
    }

    /**
     * 动态规划
     * @param height
     * @return
     */
    int method1(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        left_max[0] = height[0];
        right_max[n-1] = height[n-1];
        for(int i = 1; i < height.length; i++) {
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }
        for(int i = n-2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i+1]);
        }
        for(int i = 1; i < n; i++) {
            sum += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return sum;
    }
}

