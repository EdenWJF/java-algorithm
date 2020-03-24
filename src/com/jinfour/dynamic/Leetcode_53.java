package com.jinfour.dynamic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Leetcode_53 {

    /**
     * 最大子序和
     *
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */

    public static void main(String[] args){
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int sum = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + array[i];
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }

    public static int maxSubArray1(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
