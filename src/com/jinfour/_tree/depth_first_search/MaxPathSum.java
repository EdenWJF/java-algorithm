package com.jinfour._tree.depth_first_search;

import com.jinfour._tree.traversal.TreeNode;

public class MaxPathSum {

    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int root_max = max(root);
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        return Math.max(root_max, Math.max(left, right));
    }

    int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int ret = root.val;
        int left = max(root.left);
        int right = max(root.right);
        if(left > 0) {
            ret += left;
        }
        if(right > 0) {
            ret += right;
        }
        return ret;
    }
}
