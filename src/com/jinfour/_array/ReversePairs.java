package com.jinfour._array;

public class ReversePairs {

    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        ReversePairs rp = new ReversePairs();
        System.out.println(rp.reversePairs(arr));
    }


    public int reversePairs(int[] nums) {
        int step = 1;
        int[] tmp = new int[nums.length];
        int ans = 0;
        while(step < nums.length) {
            int left = 0;
            while(left + step < nums.length) {
                int right = Math.min(left + step * 2 - 1, nums.length-1);
                int mid = left + step - 1;
                ans += merge(nums, left, right, mid, tmp);
                left = right + 1;
            }
            step *= 2;
        }
        return ans;
    }

    int merge(int[] nums, int left, int right, int mid, int[] tmp) {
        int l = left, r = mid+1, t = 0, ans = 0;
        while(l <= mid && r <= right) {
            if(nums[l] <= nums[r]) {
                tmp[t++] = nums[l++];
            }else {
                tmp[t++] = nums[r++];
                ans += mid - l + 1;
            }
        }
        while(l <= mid) {
            tmp[t++] = nums[l++];
        }
        while(r <= right) {
            tmp[t++] = nums[r++];
        }
        t = 0;
        while(left <= right) {
            nums[left++] = tmp[t++];
        }
        return ans;
    }
}
