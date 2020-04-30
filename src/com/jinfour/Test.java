package com.jinfour;

import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        inorder(root, res);
        return res;
    }

    void inorder(TreeNode node, LinkedList list) {
        if (node.left != null) inorder(node.left, list);
        list.offer(node.val);
        if (node.right != null) inorder(node.right, list);
    }


}
