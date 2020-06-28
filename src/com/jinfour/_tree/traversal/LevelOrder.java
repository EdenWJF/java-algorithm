package com.jinfour._tree.traversal;

import java.util.LinkedList;

public class LevelOrder {

    public void levelOrder(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        TreeNode last = root;
        TreeNode nLast = root;

        while(!list.isEmpty()) {
            TreeNode node = list.poll();
            System.out.print(node.val);
            if (node.left != null) {
                list.offer(node.left);
                nLast = node.left;
            }
            if (node.right != null) {
                list.offer(node.right);
                nLast = node.right;
            }
            if (node == last) {
                System.out.println();
                last = nLast;
            }
        }
    }
}
