package com.jinfour.doublepointer;

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
        Trapping_rain_water solution = new Trapping_rain_water();
        int sum = solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(sum);
    }

    public int trap(int[] height) {
        return method1(height);
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    int method1(int[] height) {
        int n = height.length;
        int left_max = height[0]; // left_max：当前节点的左边最高的高度（包括当前节点本身）
        int right_max = height[n-1]; // right_max：当前节点的右边最高的高度（包括当前节点本身）
        int left = 1; // 左指针
        int right = n - 2; // 右指针
        int sum = 0;

        while(left <= right) {
            left_max = Math.max(left_max, height[left]);
            right_max = Math.max(right_max, height[right]);

            // 如果左边最大的小于右边最大，此时计算左边的节点，因为左边的节点能盛放水的高度肯定不高于left_max
            if(left_max < right_max) {
                sum += left_max - height[left];
                left++;
            }else {
                sum += right_max - height[right];
                right--;
            }
        }
        return sum;
    }
}

