package com.jinfour.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 *
 * https://leetcode.cn/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (57.35%)
 * Likes:    1061
 * Dislikes: 0
 * Total Accepted:    284K
 * Total Submissions: 494.7K
 * Testcase Example:  '"25525511135"'
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效 IP 地址。
 *
 *
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能
 * 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 *
 * 示例 2：
 *
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 *
 * 示例 3：
 *
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= s.length <= 20
 * s 仅由数字组成
 *
 *
 */
public class Restore_ip_addresses {

    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        String input = "101023";
        Restore_ip_addresses ria = new Restore_ip_addresses();
        ria.restoreIpAddresses(input);

        ans.forEach(System.out::println);
    }

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, 0, new String(""), 1);
        return ans;
    }

    void restoreIpAddresses(String ori, int start, String cur, int cnt) {
        if(cnt > 4 || start >= ori.length()) {
            return;
        }
        if(cnt == 4) {
            if(isValidNum(ori.substring(start))) {
                ans.add(new String(cur + "." + ori.substring(start)));
            }
            return;
        }
        cnt++;
        for(int i = 1; i <= 3 && start + i <= ori.length(); i++) {
            String t = ori.substring(start, start + i);
            if(isValidNum(t)) {
                String ip = "";
                if(cur.length() == 0) {
                    ip = new String(ori.substring(start, start + i));
                }else {
                    ip = new String(cur + "." + ori.substring(start, start + i));
                }
                restoreIpAddresses(ori, start + i, ip, cnt);
            }
        }
    }


    boolean isValidNum(String s) {
        System.out.println("check: " + s);
        if(s.length() == 1) return true;
        if(s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        if(num >= 0 && num <= 255) {
            return true;
        }
        return false;
    }
}


