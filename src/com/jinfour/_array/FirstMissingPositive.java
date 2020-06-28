package com.jinfour._array;

public class FirstMissingPositive {

    /**
     * 有一个无序的数组，要找出里面第一个没有出现的正整数，
     * 比如[1,2,0]中第一个没有出现的正整数是3，
     * [3,4,-1,1]第一个没有出现的正整数是2.
     * 在找这个数时只能使用给定的空间。
     */

    public static void main(String[] args){
        int[] arr = new int[]{2,4,3,4,1};
        System.out.println(retry(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i<len; i++) {
            while(nums[i] >= 1 && nums[i] <= len && nums[i] != nums[nums[i]-1]) {
                //nums[i] != nums[nums[i]-1]
                // 如果遍历到第i个元素的时候，
                // 1) 如果i == nums[i-1]，那么上面就等价于i!=num[i-1],打破while
                // 2) 如果i != nums[i-1]，那么按照逻辑需要置换第i个和第nums[nums[i] - 1]个元素的值，
                //      但是如果这两个值相等的话会造成死循环，所以需要用上面的条件进行判断
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }
        for(int j = 0; j < len; j++) {
            if(nums[j] != j+1) {
                return j+1;
            }
        }
        return len+1;
    }

    public static int retry(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            while(nums[i] <= len && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return len;
    }
}
