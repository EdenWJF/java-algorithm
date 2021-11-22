package com.jinfour.dynamic;

public class ArrayJump {

    // 给定一个数组，数组的每个数字代表最多能往前跳几步，从第一个数字开始，判断该数组是否可以从第一个位置跳到最后一个

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 0, 0, 6};
        System.out.println(jump(arr));
    }

    static boolean jump(int[] array) {
        int len = array.length;
        // dp数组，每一项代表是否能跳到最后一个位置；从后往前计算
        boolean[] dp = new boolean[len];

        dp[len-1] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= array[i]; j++) {
                if (i + j < len && dp[i+j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
