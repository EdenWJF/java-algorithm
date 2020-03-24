package com.jinfour._stack;

import java.util.Stack;

public class Calculator {

    //基于运算符优先级，根据字符串计算值
    //S='3+(2*5)-1'
    //输出：12

    int evaluate(char[] source) {

        Stack s1 = new Stack();//盛放符号
        Stack<Integer> s2 = new Stack();//盛放数字

        for (int i = 0; i < source.length; i++) {
            if (isDigit(source[i])) {
                s2.push(readNumber(source, i));
            }
        }
       return 0;
    }

    //读取完整数字
    private int readNumber(char[] source, int i) {
        int num = source[i];
        while (++i < source.length && isDigit(source[i])) {
            num = num * 10 + source[i];
        }
        return num;
    }

    private boolean isDigit(char s) {
        return s >= '0' && s <= '9';
    }

    public static void main(String[] args){
        int i = 0;
        while (++i > 0 && i == 1) {
            System.out.println(i);
        }
    }

}
