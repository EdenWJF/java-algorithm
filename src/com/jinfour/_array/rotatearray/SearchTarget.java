package com.jinfour._array.rotatearray;

public class SearchTarget {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 来源：力扣（LeetCode.33）
     */

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[low] <= nums[mid]) {
                //target在前半部分
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
    }
}
