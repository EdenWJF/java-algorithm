package com.jinfour._array;

public class MaxSubArray {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     */

    public static void main(String[] args){
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] arr) {
        int[] df = new int[arr.length];
        int max = arr[0];
        df[0] = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            df[i+1] = Math.max(arr[i+1], df[i] + arr[i+1]);
            max = Math.max(max, df[i+1]);
        }
        return max;
    }





















    public static int retry(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i-1], dp[i]);
        }
        return max;
    }

}
