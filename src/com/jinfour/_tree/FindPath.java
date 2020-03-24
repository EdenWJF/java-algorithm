package com.jinfour._tree;

import java.util.List;
import java.util.Stack;

public class FindPath {
    //二叉树中和为某一值的路径

    private class TreeNode {
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

    public List<Stack<TreeNode>> findPath(TreeNode current, int target, Stack<TreeNode> path, List<Stack<TreeNode>> listAll) {

        if (current == null) {
            return listAll;
        }
        path.push(current);
        target = target - current.data;
        if (target == 0 && current.left == null && current.right == null) {
            //当前节点是叶子节点
            listAll.add(path);
        }
        findPath(current.left, target, path, listAll);
        findPath(current.right, target, path, listAll);
        path.pop();
        return listAll;
    }
}
