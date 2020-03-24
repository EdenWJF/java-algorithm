package com.jinfour._stack;

import java.util.Stack;

public class ParenthesisMatching {

    //括号匹配问题
    public static void main(String[] args){
        String tsStr = "a/(b[i-1][j+1]{+c[i+1][j-1]) * 2";
        boolean paren = paren(tsStr.toCharArray(), 0, tsStr.length() - 1);
        System.out.println(paren);
    }

    static boolean paren(char[] exp, int lo, int hi) {
        Stack s = new Stack();

        while(lo++ < hi) {
            switch (exp[lo]) {
                case '(':
                case '{':
                case '[':
                    s.push(exp[lo]);
                    break;
                case ')':
                    if (s.empty() || (char)s.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (s.empty() || (char)s.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (s.empty() || (char)s.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }
        return s.empty();
    }


}
