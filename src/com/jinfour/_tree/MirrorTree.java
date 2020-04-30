package com.jinfour._tree;

import java.util.LinkedList;
import java.util.Stack;


public class MirrorTree {

    //二叉树的镜像

    public static void main(String[] args){
        BinarySearchTree.Node root = new BinarySearchTree.Node(1);
        BinarySearchTree.Node node2 = new BinarySearchTree.Node(2);
        BinarySearchTree.Node node3 = new BinarySearchTree.Node(3);
        BinarySearchTree.Node node4 = new BinarySearchTree.Node(4);
        BinarySearchTree.Node node5 = new BinarySearchTree.Node(5);
        BinarySearchTree.Node node6 = new BinarySearchTree.Node(6);
        BinarySearchTree.Node node7 = new BinarySearchTree.Node(7);
        root.left = node2; root.right = node3;
        node2.left = node4; node2.right = node5;
        node3.left = node6; node3.right = node7;
        retry1(root);
        levelOrder(root);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void mirror1(BinarySearchTree.Node root) {
        if (root == null) return;
        BinarySearchTree.Node left = root.left;
        BinarySearchTree.Node right = root.right;
        root.left = right;
        root.right = left;
        mirror1(left);
        mirror1(right);
    }

    public static void mirror2(BinarySearchTree.Node root) {
        if (root == null) return;
        Stack<BinarySearchTree.Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            BinarySearchTree.Node node = stack.pop();
            BinarySearchTree.Node temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
    }

    public static void levelOrder(BinarySearchTree.Node root) {
        if (root == null) return;
        LinkedList<BinarySearchTree.Node> list = new LinkedList<>();
        list.add(root);
        BinarySearchTree.Node cur = root;
        BinarySearchTree.Node last = root;
        while(!list.isEmpty()) {
            BinarySearchTree.Node pop = list.pop();
            System.out.print(pop.data + " ");
            if (pop.left != null) {
                list.offer(pop.left);
                cur = pop.right;
            }
            if (pop.right != null) {
                list.offer(pop.right);
                cur = pop.right;
            }
            if (last == pop) {
                System.out.println();
                last = cur;
            }
        }
    }


    public static void retry(BinarySearchTree.Node root) {
        if (root == null) return;

        BinarySearchTree.Node left = root.left;
        root.left = root.right;
        root.right = left;

        retry(root.left);
        retry(root.right);
    }

    public static void retry1(BinarySearchTree.Node root) {
        if (root == null) return;
        Stack<BinarySearchTree.Node> stack = new Stack<>();
        stack.push(root);
        BinarySearchTree.Node cur = null;
        while(!stack.empty()) {
            cur = stack.pop();
            BinarySearchTree.Node left = cur.left;
            BinarySearchTree.Node right = cur.right;
            cur.left = right;
            cur.right = left;
            if (right != null) {
                stack.push(cur.left);
            }
            if (left != null) {
                stack.push(cur.right);
            }
        }
    }
}
