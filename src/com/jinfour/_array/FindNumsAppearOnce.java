package com.jinfour._array;

import java.util.Arrays;

public class FindNumsAppearOnce {

    /**
     * 数组中只出现一次的数字
     *
     * 一个整型数组里除了两个数字之外，其他数字都出现两次，请写出程序找出这两个数字
     *
     */

    public static void main(String[] args){
        int[] arr = new int[]{2,3,4,5,2,6,3,5};
        System.out.println(Arrays.toString(findNumsAppearOnce(arr)));
    }

    public static int[] findNumsAppearOnce(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp ^= arr[i];
        }
        int n = 0, num1 = 0, num2 = 0;
        while((tmp & 1) == 0) {
            n++;
            tmp = tmp >> 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (((arr[i] >> n) & 1)== 1) {
                num1 ^= arr[i];
            }else {
                num2 ^= arr[i];
            }
        }
        return new int[]{num1, num2};
    }

}
