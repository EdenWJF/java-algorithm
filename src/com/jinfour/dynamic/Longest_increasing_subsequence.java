package com.jinfour.dynamic;

public class Longest_increasing_subsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,3,5,4,7}));
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums.length < 2) return nums.length;
        return findNumberOfLISInternal(nums);
    }

    private static int lengthOfLISInternal(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    private static int lengthOfLISInternal1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max_len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[max_len-1]) {
                dp[max_len] = nums[i];
                max_len++;
            }else {
                // 二分查找，找出比nums[i]大的元素列表中最小的那个，并覆盖掉
                int l = 0, r = max_len-1;
                while(l <= r) {
                    int m = (l+r)/2;
                    if(nums[i] > dp[m]) {
                        l = m+1;
                    }else {
                        r = m-1;
                    }
                }
                dp[l] = nums[i];
            }
        }
        return max_len;
    }

    private static int findNumberOfLISInternal(int[] nums) {

        int[] dp = new int[nums.length];
        // 以i结尾的最长子序列的个数
        int[] cnt = new int[nums.length];
        int max_len = 0, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        // 以i结尾的子序列中，发现有更长的递增子序列，重置cnt[i]
                        cnt[i] = cnt[j];
                    }else if(dp[j] + 1 == dp[i]){
                        cnt[i] += cnt[j];
                    }
                }
            }
            if(dp[i] > max_len) {
                max_len = dp[i];
                ans = cnt[i];
            }else if(dp[i] == max_len) {
                ans = ans + cnt[i];
            }
        }
        return ans;
    }
}
