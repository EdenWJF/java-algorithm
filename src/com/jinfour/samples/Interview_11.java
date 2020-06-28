package com.jinfour.samples;

public class Interview_11 {

    //旋转数组中的最小数字

    static int getMin(int[] arr) {
        int i = 0, j = arr.length - 1;
        if (arr[i] < arr[j]) {
            return arr[i];
        }
        while(j - i > 1) {
            int mid = (i + j) >> 1;
            if (arr[mid] > arr[j]) {
                i = mid;
            }else {
                j = mid;
            }
        }
        return arr[j];
    }

    public static void main(String[] args){
        int[] arr = new int[] {1,1,0,1};
        System.out.println(getMin(arr));
    }



















    static int retry(int[] arr) {
        int low = 0, high = arr.length - 1;
        int middle = (low + high)/2;
        while(low < high) {
            if (arr[low] < arr[middle]) {
                low = middle + 1;
            }else if (arr[low] > arr[middle]) {
                high = middle - 1;
            }
            if (arr[high] > arr[middle]) {
                high = middle - 1;
            }else if (arr[high] < arr[middle]) {
                low = middle + 1;
            }
        }
        return arr[low];
    }
}
