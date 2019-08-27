package com.jinfour.search;

public class BinarySearch {

    //二分查找

    public static void main(String[] args){
        int[] arr = new int[] {1, 3, 4, 6, 8, 12};
        System.out.println(binarySearch((arr), 12));
    }

    static int binarySearch(int[] source, int target) {
        int low = 0;
        int high = source.length;

        while(low <= high) {
            int middle = (low + high)/2;

            if (target == source[middle]) {
                return middle;
            }

            if (target > source[middle]) {
                low = middle + 1;
            }

            if (target < source[middle]) {
                high = middle - 1;
            }

        }

        return -1;
    }
}
