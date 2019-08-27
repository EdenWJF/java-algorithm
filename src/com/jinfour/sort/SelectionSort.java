package com.jinfour.sort;

import java.util.Arrays;

public class SelectionSort {

    //选择排序

    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    //swap
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }

            }
        }
        return arr;
    }

    //冒泡排序
    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j+1]) {
                    //swap
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }

            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = new int[] {2, 3, 1, 8, 5, 4, 9, 3};
        arr = bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
