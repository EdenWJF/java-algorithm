package com.jinfour._stack;

import java.util.Stack;

public class Basic_calculator {

    public static void main(String[] args) {
        Basic_calculator bc = new Basic_calculator();
        System.out.println(bc.calculate("1 + 1"));
    }

    public int calculate(String s) {
        char[] ch = s.toCharArray();
        int ans = 0; // 运算结果
        int sign = 1; // 运算符 1：+， -1： -
        int num = 0; // 读取当前数字
        int len = ch.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < len; i++) {
            char c = ch[i];
            if(c == ' ') continue;
            if(c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                if(i < len - 1 && (ch[i+1] >= '0' && ch[i+1] <= '9')) {
                    // 如果下个字符还是数字，不再往下执行
                    continue;
                }
            }else if(c == '(') {
                // 如果是右括号，则需要把当前值和运算符存入栈里
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            }else if(c == ')') {
                sign = stack.pop();
                num = ans;
                ans = stack.pop();
            }else {
                sign = (c == '+' ? 1 : -1);
                num = 0;
            }
            ans += (sign == 1 ? num : -num);
        }
        return ans;
    }
}

/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 *
 * https://leetcode.cn/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (42.29%)
 * Likes:    846
 * Dislikes: 0
 * Total Accepted:    106.2K
 * Total Submissions: 251.1K
 * Testcase Example:  '"1 + 1"'
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "1 + 1"
 * 输出：2
 *
 *
 * 示例 2：
 *
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 *
 *
 * 示例 3：
 *
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= s.length <= 3 * 10^5
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 *
 *
 */


