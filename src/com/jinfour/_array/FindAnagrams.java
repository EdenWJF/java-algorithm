package com.jinfour._array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 *
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (54.88%)
 * Likes:    1053
 * Dislikes: 0
 * Total Accepted:    249.2K
 * Total Submissions: 454.1K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *
 * 示例 2:
 *
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 *
 *
 * 提示:
 *
 *
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 *
 *
 */
public class FindAnagrams {

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("bpaa", "aa");
        System.out.println(anagrams);
    }


    public static List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        List<Integer> ans = new ArrayList<>();
        if(len > s.length()) {
            return ans;
        }
        int[] arr = new int[26];
        int diff = 0;
        for(int i = 0; i < len; i++) {
            arr[s.charAt(i)-'a']++;
            arr[p.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(arr[i] != 0) {
                diff++;
            }
        }
        if(diff==0) {
            ans.add(0);
        }
        for(int i = 1; i < s.length() - len + 1; i++) {
            char del = s.charAt(i-1);
            char add = s.charAt(i+len-1);
            if(arr[del-'a'] == 1) {
                diff--;
            }else if (arr[del-'a'] == 0){
                diff++;
            }
            arr[del-'a']--;
            if(arr[add-'a'] == -1) {
                diff--;
            }else if (arr[add-'a'] == 0){
                diff++;
            }
            arr[add-'a']++;
            if(diff == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}


