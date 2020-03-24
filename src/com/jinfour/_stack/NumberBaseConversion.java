package com.jinfour._stack;

import java.util.Iterator;
import java.util.Stack;

public class NumberBaseConversion {

    private static char digit[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    //进制转换
    private static void convert(Stack s, int number, int base) {
        while(number > 0) {
            int remainder = number % base;
            s.push(digit[remainder]);
            number = number / base;
        }
    }

    public static void main(String[] args){
        int n = 12345;
        Stack s = new Stack();
        convert(s, n, 8);
        String res = "";
        Iterator iterator = s.iterator();
        while (iterator.hasNext()) {
            res = res + s.pop();
        }
        System.out.println(res);
    }
}
