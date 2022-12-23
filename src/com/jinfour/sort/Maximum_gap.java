package com.jinfour.sort;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 *
 * https://leetcode.cn/problems/maximum-gap/description/
 *
 * algorithms
 * Hard (60.46%)
 * Likes:    526
 * Dislikes: 0
 * Total Accepted:    77.1K
 * Total Submissions: 127.6K
 * Testcase Example:  '[3,6,9,1]'
 *
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 *
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * 示例 2:
 *
 *
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 *
 *
 * 提示:
 *
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 *
 *
 */

import java.util.LinkedList;

public class Maximum_gap {

    public static void main(String[] args) {
        Maximum_gap mg = new Maximum_gap();
        System.out.println(mg.maximumGap(new int[]{3,6,9,1}));
    }

    public int maximumGap(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        LinkedList<Integer>[] bucket = new LinkedList[10];

        for(int i = 0; i < 10; i++) {
            bucket[i] = new LinkedList<>();
        }
        int maxLen = getMaxLen(nums);
        for(int i = 1; i <= maxLen; i++) {

            // 分桶
            for(int j = 0; j < nums.length; j++){
                bucket[getIndex(nums[j], i)].add(nums[j]);
            }

            // 收集桶
            int idx = 0;
            for(int k = 0; k < 10; k++) {
                while(!bucket[k].isEmpty()) {
                    nums[idx++] = bucket[k].poll();
                }
            }
        }
        int maxSpan = 0;
        for(int i = 1; i < nums.length; i++) {
            maxSpan = Math.max(maxSpan, Math.abs(nums[i] - nums[i-1]));
        }
        return maxSpan;
    }

    int getIndex(int num, int r) {
        int idx = 0;
        for(int i = 0; i < r; i++) {
            idx = num % 10;
            num /= 10;
        }
        return idx;
    }

    int getMaxLen(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return (max + "").length();
    }
}
