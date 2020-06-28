package com.jinfour._array.rotatearray;

import java.util.Arrays;

public class RotateArray {

    /**
     * Leetcode.189 旋转数组
     *
     */

    public static int[] rotate(int[] arr, int k) {
        if (arr == null || arr.length < 2 || k > arr.length) {
            return arr;
        }

        int len = arr.length;
        for (int i = 0; i < len/2; i++) {
            swap(arr, i, len - 1 - i);
        }

        int leftEnd = len - 1 - k;
        for (int i = 0; i < leftEnd/2; i++) {
            swap(arr, i, leftEnd - 1 - i);
        }

        while(leftEnd < len - 1) {
            swap(arr, leftEnd, len - 1);
            leftEnd++;
            len--;
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,7};
        arr = rotate(arr, 3);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
