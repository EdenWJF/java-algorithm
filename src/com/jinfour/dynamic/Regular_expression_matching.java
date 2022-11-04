package com.jinfour.dynamic;

/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 *
 * https://leetcode.cn/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (31.68%)
 * Likes:    3168
 * Dislikes: 0
 * Total Accepted:    308.2K
 * Total Submissions: 972.9K
 * Testcase Example:  '"aa"\n"a"'
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 *
 *
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 *
 * 示例 2:
 *
 *
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 *
 * 示例 3：
 *
 *
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 *
 */
public class Regular_expression_matching {

    public static void main(String[] args) {
        Regular_expression_matching rem = new Regular_expression_matching();
        System.out.println(rem.isMatch("abcaa", "a*bca*"));
    }

    public boolean isMatch(String s, String p) {
        int row = s.length() + 1;
        int col = p.length() + 1;
        boolean[][] dp = new boolean[row][col];
        dp[0][0] = true;

        for(int i = 1; i < col; i++) {
            char c = p.charAt(i-1);
            if((c >= 'a' && c <= 'z') || c == '.') {
                dp[0][i] = false;
            }else {
                // c == '*'
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(p.charAt(j-1) >= 'a' && p.charAt(j-1) <= 'z') {
                    if(s.charAt(i-1) == p.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = false;
                    }
                }else if (p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // c == '*'
                    dp[i][j] = dp[i][j-2] || dp[i][j-1] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]);
                }
            }
        }
        return dp[row-1][col-1];
    }
}
