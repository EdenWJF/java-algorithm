package com.jinfour.sort;

public class QuickSort {


    private static void sort(int[] arr, int low, int high) {

        int index = getIndex(arr, low, high);
        if (low < high) {
            sort(arr, low, index - 1);
            sort(arr, index + 1, high);
        }

    }


    private static int getIndex(int[] arr, int low, int high) {

        int pivot = arr[low];

        while(low < high) {

            while(low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];

            while(low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];

        }
        arr[low] = pivot;
        return low;

    }

    public static void main(String[] args){
        int[] arr = new int[] {2, 3, 1, 8, 5, 4, 9, 3};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
