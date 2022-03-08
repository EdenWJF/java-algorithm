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
        sort0(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 更好理解点的插入排序
     * @param a
     */
    static void sort0(int[] a) {

        for (int i = 1; i < a.length; i++) {

            if (a[i] < a[i-1]) {

                int tmp = a[i];
                int j = i - 1;
                // 此处循环是将原序列平移
                for (; j >= 0 && tmp < a[j]; j--) {
                    a[j+1] = a[j];
                }
                a[j+1] = tmp;
            }
        }

    }
}
