package com.jinfour.samples;

public class Interview_03 {

    //数组中重复的数字

    public static void main(String[] args){
        int[] a = new int[]{2,3,1,6,4,5,1};

        System.out.println(duplicate_02(a));
    }


    //******************************************************************
    //该方法改变了原数组，时间复杂度为O(n)
    static int duplicate_01(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            while(i != arr[i]) {
                if (arr[i] == arr[arr[i]]) return arr[i];
                swap(arr, i);
            }
        }
        return -1;

    }

    static void swap(int[] arr, int a) {
        int tmp = arr[a];

        arr[a] = arr[arr[a]];

        arr[tmp] = tmp;
    }


    //******************************************************************
    //该方法没有改变原数组，没有申请新的地址空间，时间复杂度为O(nlogn)

    static int duplicate_02(int[] arr) {

        int low=1,high=arr.length-1;

        while(low <= high) {
            //数组长度为n+1，取值范围在1~n;所以mid的值是n/2
            int mid = (low+high)>>1;
            int count = countRange(arr, low, mid);

            if (low == high) {
                return low;
            }

            if (count > mid-low+1) {
                high = mid;
            }else {
                low = mid+1;
            }

        }


        return -1;

    }

    //遍历数组，计算满足该取值范围内的值的数量
    private static int countRange(int[] arr, int low, int high) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= low && arr[i] <= high) {
                count++;
            }
        }
        return count;
    }

}
