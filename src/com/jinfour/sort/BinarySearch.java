package com.jinfour.sort;

public class BinarySearch {

    //二分查找

    public static void main(String[] args){

    }

    int binarySearch(int[] source, int target) {
        int low = 0;
        int high = source.length;
        int middle = (low + high)/2;
        while(low <= high) {

            if (target == source[middle]) {
                return middle;
            }

            if (target > source[middle]) {

            }
        }

        return -1;
    }
}
