package com.jinfour._tree;

import sun.reflect.generics.tree.Tree;

public class LongestCommonAncestor {

    //查找二叉树中两个节点的公共最近祖先
    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    static TreeNode solution(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null || current.data == p.data || current.data == q.data)
            return current;
        TreeNode left = solution(current.left, p, q);
        TreeNode right = solution(current.right, p, q);
        if (left != null && right != null)
            return current;
        return left == null ? right : left;
    }



















    TreeNode retry(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = retry(root.left, p, q);
        TreeNode right = retry(root.right, p , q);

        if (left != null && right != null) {
            return root;
        }
        return left == null?right:left;

    }

}
