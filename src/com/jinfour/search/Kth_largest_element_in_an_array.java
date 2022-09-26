package com.jinfour.search;

import java.util.Random;

public class Kth_largest_element_in_an_array {

    public static void main(String[] args) {
        Kth_largest_element_in_an_array kth = new Kth_largest_element_in_an_array();
        int r = kth.findKthLargest(new int[]{3,2,1,5,6,4,7,5}, 2);
        System.out.println(r);
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }

    public void quickSort(int[] nums, int low, int high) {
        if(low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot-1);
            quickSort(nums, pivot+1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int r = new Random().nextInt(high-low) + low;
        swap(nums, high, r);
        int pivot = low-1;
        for(int i = low; i < high; i++) {
            if (nums[i] <= nums[high]) {
                pivot++;
                swap(nums, pivot, i);
            }
        }
        pivot++;
        swap(nums, pivot, high);
        return pivot;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (64.69%)
 * Likes:    1805
 * Dislikes: 0
 * Total Accepted:    707.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 *
 *
 * 示例 2:
 *
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 *
 */




