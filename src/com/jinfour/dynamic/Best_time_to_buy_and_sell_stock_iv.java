package com.jinfour.dynamic;

public class Best_time_to_buy_and_sell_stock_iv {

    public static void main(String[] args) {
        int k = 2;
        int[] prices = new int[]{2, 4, 1};
        int i = new Best_time_to_buy_and_sell_stock_iv().maxProfit(k, prices);
        System.out.println(i);

        String s  = "abcdefg";
        String s1 = s.substring(0, 3);
        s = "efsfges";
        System.out.println(s1);
    }

    public int maxProfit(int k, int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        return maxProfitInternal(k, prices);
    }

    private int maxProfitInternal(int k, int[] prices) {
        int len = prices.length;
        if(k > len/2) k = len/2;

        // 状态：时间、持有现金/股票、卖出次数
        int[][][] dp = new int[len][2][k+1];
        for(int i = 0; i <= k; i++) {
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }
        for(int i = 1; i < len; i++) {
            for(int j = 0; j <= k; j++) {
                if(j == 0) {
                    dp[i][0][j] = 0;
                }else {
                    // 第i天，持有现金，卖出j次
                    dp[i][0][j] = Math.max(dp[i-1][0][j], dp[i-1][1][j-1] + prices[i]);
                }
                // 第i天，持有股票，卖出j次
                dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][0][j] - prices[i]);
            }
        }
        int max = 0;
        for(int i = 0; i <= k; i++) {
            max = Math.max(dp[len-1][0][k], max);
        }
        return max;
    }
}
