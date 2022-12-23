package com.jinfour.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode.cn/problems/subsets/description/
 *
 * algorithms
 * Medium (80.85%)
 * Likes:    1842
 * Dislikes: 0
 * Total Accepted:    542K
 * Total Submissions: 670.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 *
 * 示例 2：
 *
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1
 * -10
 * nums 中的所有元素 互不相同
 *
 *
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
//        subsets.subsets(new int[]{1,2,3});
        System.out.println(subsets.ans);

        subsets.subsetsWithDup(new int[]{1,1,2,2});
        System.out.println(subsets.ans);
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    void backtrack(int[] nums, int begin, List<Integer> list) {
        for(int i = begin; i < nums.length; i++) {
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            backtrack(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        boolean[] used = new boolean[nums.length];
        backtrack(nums, 0, new ArrayList<>(), used);
        return ans;
    }

    void backtrack(int[] nums, int begin, List<Integer> list, boolean[] used){
        for(int i = begin; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            ans.add(new ArrayList<>(list));
            backtrack(nums, i+1, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
