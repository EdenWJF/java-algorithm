package com.jinfour.leetcode;

import java.util.*;

public class LeetCode_46 {
    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     * @param nums
     * @return
     */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private static void backtrack(int[] nums, List<Integer> list, boolean[] visited,  List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, list, visited, res);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> permute = permute(arr);
        for (List<Integer> subList : permute) {
            System.out.println(subList);
        }
    }
}
