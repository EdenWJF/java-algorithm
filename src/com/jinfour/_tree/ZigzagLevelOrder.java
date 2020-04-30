package com.jinfour._tree;

import java.util.Stack;

public class ZigzagLevelOrder {

    //之字形打印二叉树

    static void print(BinarySearchTree.Node root) {
        Stack<BinarySearchTree.Node>[] stack = new Stack[2];
        stack[0] = new Stack<>();
        stack[1] = new Stack<>();
        int next = 1;
        int current = 0;
        stack[current].push(root);

        while(!stack[0].empty() || !stack[1].empty()) {
            BinarySearchTree.Node pop = stack[current].pop();
            System.out.print(pop.data + " ");
            BinarySearchTree.Node left = pop.left;
            BinarySearchTree.Node right = pop.right;
            if (next == 1) {
                if (left != null) stack[1-current].push(left);
                if (right != null) stack[1-current].push(right);
            }else {
                if (right != null) stack[1-current].push(right);
                if (left != null) stack[1-current].push(left);
            }

            if (stack[current].empty()) {
                current = 1 - current;
                next = 1 - next;
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        BinarySearchTree.Node root = new BinarySearchTree.Node(1);
        BinarySearchTree.Node node2 = new BinarySearchTree.Node(2);
        BinarySearchTree.Node node3 = new BinarySearchTree.Node(3);
        BinarySearchTree.Node node4 = new BinarySearchTree.Node(4);
        BinarySearchTree.Node node5 = new BinarySearchTree.Node(5);
        BinarySearchTree.Node node6 = new BinarySearchTree.Node(6);
        BinarySearchTree.Node node7 = new BinarySearchTree.Node(7);
        BinarySearchTree.Node node8 = new BinarySearchTree.Node(8);
        BinarySearchTree.Node node9 = new BinarySearchTree.Node(9);
        root.left = node2; root.right = node3;
        node2.left = node4; node2.right = node5;
        node3.left = node6; node3.right = node7;
        node4.left = node8;
        node7.right = node9;

        print(root);
    }
}
