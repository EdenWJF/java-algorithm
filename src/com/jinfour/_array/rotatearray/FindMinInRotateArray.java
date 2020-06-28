package com.jinfour._array.rotatearray;

public class FindMinInRotateArray {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     *
     * 示例 1：
     *
     * 输入：[3,4,5,1,2]
     * 输出：1
     *
     * 来源：力扣（LeetCode.11）
     */

    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }else if (nums[mid] < nums[high]){
                high = mid;
            }else {
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args){
        int[] arr1 = {3,4,5,6,7,1,2};
        int[] arr2 = {6,7,1,2,3,4,5};
        int[] arr3 = {1,1,1,1,0,1,1};

        System.out.println(findMin(arr1));
        System.out.println(findMin(arr2));
        System.out.println(findMin(arr3));
    }
}
