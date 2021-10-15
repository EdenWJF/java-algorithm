package com.jinfour.dynamic;

import java.util.Arrays;

public class DynamicSamples {

    public static void main(String[] args) {
        int total = 11;
        int[] coins = {5, 3};
        int valueIndex = 0;
        int valueCount = coins.length;

        int i = GetMinCoinCountOfValueHelper(total, coins, valueIndex, valueCount);
//        int y = getMinCountsHelper(total, coins, new int[total]);
        System.out.println(i);

        int N = 5;
        int[] m = new int[N + 1];
        int fibonacci = Fibonacci(N, m);
        System.out.println(fibonacci);

        System.out.println(getMinCounts(total, coins));
    }


    // 动态规划，练手

    /**
     * @param total           输入目标总值
     * @param values          货币数组
     * @param currentMaxIndex 数组值从大到小排序，当前用到的最大的货币的索引
     * @param originLength    数组的长度
     * @return values搭配valueIndex定义新数组，该数组内的值解决当前total，所需的最小硬币总数
     */
    public static int GetMinCoinCountOfValueHelper(int total, int[] values, int currentMaxIndex, int originLength) {
        if (currentMaxIndex >= originLength) {
            return -1;
        }
        int maxCount = total / values[currentMaxIndex]; // 贪心：当前总值/数组中最大值
        for (int count = maxCount; count >= 0; count--) { // count 代表当前使用了多少硬币
            int rest = total - count * values[currentMaxIndex]; // 总值-最大值硬币总值
            if (rest == 0) { // 如果剩余数值为0，代表不需要再往下计算了
                return count;
            }
            int remain = GetMinCoinCountOfValueHelper(rest, values, currentMaxIndex + 1, originLength);
            if (remain == -1) { // 说明当前总值无法被剩余硬币平分
                if (count == 0) { // 当硬币无法被平分，且之前也没有使用过硬币，说明当前问题，无法解决，返回-1
                    return -1;
                }
                continue; // 回溯，放入两个最大的硬币不行，那就减少一个试一下
            }
            return count + remain;
        }
        return -1;
    }

    static int getMinCountsHelper(int total, int[] values, int[] mark) { // 如果余额为0，说明当前组合成立，将组合加入到待选数组中
        if (0 == total) {
            return 0;
        }
        if (mark[total] != -2) return mark[total];
        int valueLength = values.length;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < valueLength; i++) { // 遍历所有面值
            int currentValue = values[i];
            // 如果当前面值大于硬币总额，那么跳过
            if (currentValue > total) {
                continue;
            }
            int rest = total - currentValue; // 使用当前面值，得到剩余硬币总额
            int restCount = getMinCountsHelper(rest, values, mark);
            // 如果返回-1，说明组合不可信，跳过
            if (restCount == -1) {
                continue;
            }
            int totalCount = 1 + restCount; // 保留最小总额
            if (totalCount < minCount) {
                minCount = totalCount;
            }
        }
        // 如果没有可用组合，返回-1
        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }
        mark[total] = minCount;
        return minCount; // 返回最小硬币数量
    }

    static int getMinCounts(int k, int[] values) {
        int[] memo = new int[k + 1];
        Arrays.fill(memo, k+1);
        memo[0] = 0; // 初始化状态

        for (int v = 1; v < k+1; v++) {
            for (int coin : values) {
                if (coin > v) continue;
                memo[v] = Math.min(memo[v], memo[v - coin] + 1);
            }
        }
        return memo[k] < k + 1 ? memo[k] : -1;
    }


    static int Fibonacci(int n, int[] m) {
        if (n == 0 || n == 1) return n;
        if (m[n] > 0) return m[n];
        int res = Fibonacci(n - 1, m) + Fibonacci(n - 2, m);
        m[n] = res;
        return res;
    }

    static int maxArr(int[] arr) {
        if (arr.length == 1) return arr[0];
        int sum = arr[0];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (dp[0] + arr[i] > dp[0]) {
                dp[i] = dp[0] + arr[i];
            }else {

            }

        }
        return sum;
    }
}
