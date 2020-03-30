package com.jinfour._array;

import java.util.Arrays;

public class FindNumberAppearingOnce {

    /**
     * 数组中唯一只出现一次的数字
     *
     * 一个整型数组里除了一个数字之外，其他数字都出现三次，请写出程序找出这个数字
     *
     */

    public static void main(String[] args){
        int[] arr = new int[]{2,3,2,5,2,6,3,5,3,5};
        System.out.println(findNumberAppearingOnce(arr));
    }

    private static int findNumberAppearingOnce(int[] arr) {

        int[] bitArray = new int[32];
        for (int val : arr) {
            int index = 31;
            while (val > 0) {
                if ((val & 1) == 1) {
                    bitArray[index] += 1;
                }
                index--;
                val >>= 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((bitArray[i] % 3) != 0) {
                res += 1 << (31 - i);
            }
        }
        return res;
    }

}
