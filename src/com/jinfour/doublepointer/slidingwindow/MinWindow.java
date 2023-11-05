package com.jinfour.doublepointer.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode.cn/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (44.90%)
 * Likes:    2214
 * Dislikes: 0
 * Total Accepted:    359.4K
 * Total Submissions: 800.3K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""。
 * 注意：
 *
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 *
 * 示例 2：
 *
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 *
 * 示例 3:
 *
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 *
 *
 * 提示：
 *
 *
 * 1
 * s 和 t 由英文字母组成
 *
 *
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 */
public class MinWindow {
    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> tMap = new HashMap<>();

    public static void main(String[] args) {
        MinWindow mw = new MinWindow();
        String check = mw.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(check);
    }

    public String minWindow(String s, String t) {
        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while(right < s.length()) {
            if (tMap.containsKey(s.charAt(right))) {
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            while(check(sMap, tMap) && left <= right) {
                if(right - left + 1 < len) {
                    ansL = left;
                    ansR = right;
                    len = right - left + 1;
                }
                if (sMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                }
                left++;
            }
            right++;
        }
        return s.substring(ansL, ansR+1);
    }

    boolean check(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for(Character c : tMap.keySet()) {
            if (!sMap.containsKey(c) || sMap.get(c) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
