package com.jinfour._stack;

import java.util.Stack;

public class StackWithMax {

    /**
     * 一个整数栈stack，具有push和pop操作，其时间空间复杂度皆为O(1)。
     * 设计算法max操作，求栈中的最大值，该操作的时间空间复杂度也要求为O(1)。
     * 可以修改栈的存储方式，push，pop的操作，但是要保证O(1)的时间空间复杂度。
     */

    public static Stack<Integer> val = new Stack<>();
    private static int maxVal = Integer.MIN_VALUE;

    public int pop() throws Exception {
        if (val.empty()) {
            throw new Exception();
        }
        Integer pop = val.pop();
        if (val.empty()) {
            pop = Integer.MIN_VALUE + pop;
            maxVal = Integer.MIN_VALUE;
        }else {
            if (pop > 0) {
                int tmp = pop;
                pop = maxVal;
                maxVal = maxVal - tmp;
            }else {
                pop = maxVal + pop;
            }
        }
        return pop;
    }

    public void push(int i) {
        if (val.empty()) {
            val.push(i - Integer.MIN_VALUE);
            maxVal = i;
        }else {
            if (i > maxVal) {
                val.push(i - maxVal);
                maxVal = i;
            }else {
                val.push(i - maxVal);
            }
        }
    }

    public int getMax() {
        return maxVal;
    }

    public static void main(String[] args) throws Exception {
        StackWithMax stack = new StackWithMax();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(7);
        stack.push(6);
        stack.push(9);
        stack.push(9);
        System.out.println(stack.getMax());
        stack.pop();
        System.out.println(stack.getMax());
        stack.pop();
        System.out.println(stack.getMax());
    }
}
