package com.jinfour._array;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length-1;
        int i = 0;
        while(i <= p2) {
            if(nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                i++;
            }else if(nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }else {
                i++;
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
