package com.jinfour._array.rotatearray;

public class SearchTargetInDuplicateArray {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     *
     * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     *
     * 示例 1:
     *
     * 输入: nums = [2,5,6,0,0,1,2], target = 0
     * 输出: true
     *
     * 来源：力扣（LeetCode.81）
     * @param nums
     * @param target
     * @return
     */

    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            if (nums[low] < nums[mid]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else if (nums[low] > nums[mid]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }else {
                low++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr1 = new int[]{1,1,1,0,1};
        int[] arr2 = new int[]{1,1,2,1,1,1};

        System.out.println(search(arr1, 0));
        System.out.println(search(arr2, 0));
    }
}
