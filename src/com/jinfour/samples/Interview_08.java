package com.jinfour.samples;

public class Interview_08 {

    //二叉树的下一个节点

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

    static TreeNode getNext(TreeNode root) {

        if (root == null) {
            return null;
        }

        //如果该节点的右节点不为空，那该节点的下个节点是最左子节点
        if (root.right != null) {
            TreeNode node = root.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }else {
            //如果右节点为空，往上回溯，知道找到该节点的作为左子树出现的父节点
            TreeNode current = root;
            TreeNode parent = root.parent;
            while(parent != null && current == parent.right) {
                current = parent;
                parent = parent.parent;
            }
            return parent;
        }

    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2;node1.right=node3;node2.parent=node1;node3.parent=node1;
        node2.left = node4;node2.right=node5;node4.parent=node1;node5.parent=node1;
        node3.left = node6;node3.right=node7;node6.parent=node3;node7.parent=node3;
        node5.left = node8;node5.right=node9;node8.parent=node5;node9.parent=node5;

        TreeNode next = getNext(node7);
        System.out.println(next);
    }
}
