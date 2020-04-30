package com.jinfour._string;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TransferQueue;

public class LengthOfLongestSubstring {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * @param args
     */

    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int retry(String s ) {
        int n = s.length(), ans = 0;
        int[] charArr = new int[128];

        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(charArr[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            charArr[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
