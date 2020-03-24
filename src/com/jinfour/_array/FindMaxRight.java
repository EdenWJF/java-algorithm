package com.jinfour._array;

import java.util.Stack;

public class FindMaxRight {
    /**
     * 找到数组中每个数字右边第一个大于该数字的值
     * @param args
     */

    public static void main(String[] args){
        int[] arr = new int[]{6,3,4,5,7,2,8,10};
        int[] maxRight = findMaxRight(arr);
        for (int i = 0; i < maxRight.length; i++) {
            System.out.print(maxRight[i] +" ");
        }
    }

    public static int[] findMaxRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.empty() && arr[i] > arr[stack.peek()]) {
                Integer pop = stack.pop();
                arr[pop] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            Integer pop = stack.pop();
            arr[pop] = -1;
        }
        return arr;
    }
}
