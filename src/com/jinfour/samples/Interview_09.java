package com.jinfour.samples;

import java.util.Stack;

public class Interview_09 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    //两个栈实现队列

    void appendTail(Integer i) {
        stack1.push(i);
    }

    int deleteHead() {
        if (stack2.size() <= 0) {
            while(stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.size() == 0) {
            return -1;
        }

        return stack2.pop();
    }
}
