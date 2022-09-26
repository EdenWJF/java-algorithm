package com.jinfour._stack.monotonous_stack;

import java.util.Stack;

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
     * 单调栈：指栈内数值要么从小到大，要么从大到小
     * @param height
     * @return
     */
    int method1(int[] height) {
        int sum = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<>(); // 单调栈存储的是高度递增的元素下标
        while(current < height.length) {
            while(!stack.empty() && height[current] > height[stack.peek()]) {
                int low = stack.pop();
                if(stack.empty()) {
                    break;
                }
                int h = Math.min(height[current], height[stack.peek()]) - height[low];
                sum += h * (current - stack.peek() - 1);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}

