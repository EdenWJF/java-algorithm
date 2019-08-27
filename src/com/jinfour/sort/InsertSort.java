package com.jinfour.sort;

public class InsertSort {

    //插入排序
    static void sort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {

            int j = i;
            int tmp = a[i + 1];

            while (tmp < a[j]) {
                a[j + 1] = a[j];
                if (j-- == 0) {
                    break;
                }
            }
            a[j + 1] = tmp;
        }
    }


    public static void main(String[] args){
        int[] arr = new int[] {2, 3, 1, 8, 5, 4, 9, 3};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
