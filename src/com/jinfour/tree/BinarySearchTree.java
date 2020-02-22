package com.jinfour.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTree {

    /**
     * 二叉搜索树，是指一棵空树或者具有下列性质的二叉树：
     *
     *      若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
     *      若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
     *      任意节点的左，右子树也分别为二叉搜索树；
     *      没有键值相等的节点。
     */
     static class Node { // 节点类
        int data; // 数据域
        int height;//AVL使用
        Node right; // 右子树
        Node left; // 左子树

        public Node(int n) {
            this.data = n;
        }

        boolean isBalanced() {
            int leftHeight = left == null ? -1 : left.height;
            int rightHeight = right == null ? -1 : right.height;
            return Math.abs(leftHeight - rightHeight) <= 1;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }



    Node root; // 树根节点

    BinarySearchTree() {

    }

    public Node search(int e) {
        if (root == null)
            return null;
        Node current = root;
        while(current.data != e) {
            if (current.data > e)
                current = current.left;
            else
                current = current.right;
            if (current == null)
                return null;
        }
        return current;

    }

    public void insert(int e) {
        root = insert0(root, e);
    }

    public Node insert0(Node node, int e) {
//        System.out.println("in BST");
        Node p = new Node(e);
        if (node == null) {
            node = p;
        }else {
            Node parent = node;
            for (;;) {
                if (parent.data == e) return null;
                if (parent.data < e) {
                    if (parent.right == null) {
                        parent.right = p;
                        return node;
                    }else {
                        parent = parent.right;
                    }
                }else {
                    if (parent.left == null) {
                        parent.left = p;
                        return node;
                    }else {
                        parent = parent.left;
                    }
                }
            }
        }
        return node;
    }

    /**
     * ============================================
     * 递归遍历
     * ============================================
     */

    //前序遍历(中、左、右)
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历(左、中、右)
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    //后序遍历(左、右、中)
    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    //层次遍历
    public static void levelOrder(Node root) {
        if (root == null) return;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        for (;;) {
            if (list.isEmpty()) break;
            Node pop = list.pop();
            if (pop.left != null)
                list.add(pop.left);
            if (pop.right != null)
                list.add(pop.right);
            System.out.print(pop.data + " ");
        }
    }

    /** ============================================ **/



    /**
     * ============================================
     * 迭代遍历
     * ============================================
     */
    public static void travPre(Node root) {
        Stack<Node> s = new Stack<>();
        Node current = root;
        for (;;) {
            for (;;) {
                if (current == null) break;
                System.out.print(current.data + " ");
                if (current.right != null) {
                    s.push(current.right);
                }
                current = current.left;
            }
            if (s.empty()) return;
            current = s.pop();
        }
    }

    public static void travIn(Node root) {
        Stack<Node> s = new Stack<>();
        Node current = root;
        for (;;) {
            while(current != null) {
                s.push(current);
                current = current.left;
            }
            if (s.empty()) return;
            current = s.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    public static void travPost(Node root) {
        Stack<Node> s = new Stack<>();
        Stack<Integer> result = new Stack<>();
        Node current = root;
        if (root == null) return;
        s.push(current);
        while (!s.empty()) {
            current = s.pop();
            if (current.left != null) s.push(current.left);
            if (current.right != null) s.push(current.right);
            result.push(current.data);
        }
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.print(result.pop() + " ");
        }
    }


    //查询后继节点
    protected Node getSuccessor(Node e) {
        if (e == null) return null;

        Node current = e;
        if (current.right != null) {
            current = current.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }else {
            Node successor = null;
            current = root;
            for (;;) {
                if (current.data == e.data) return successor;
                if (e.data > current.data) {
                    current = current.right;
                } else {
                    successor = current;
                    current = current.left;
                }
            }
        }
    }

    public void remove(int e) {
        Node current = root;
        Node parent = null;
        Node del = null;

        boolean isRightChild = false;
        //找到该节点和其父节点所在位置，并确定该节点是其父节点的左孩子还是右孩子
        for (;;) {
            if (current.data == e) {
                del = current;
                break;
            }
            parent = current;
            if (current.data > e) {
                current = current.left;
                isRightChild = false;
            }else {
                current = current.right;
                isRightChild = true;
            }
            if (current == null) return;
        }

        if (del.left == null && del.right == null) {
            //如果该节点没有子节点
            if (isRightChild) {
                parent.right = null;
            }else {
                parent.left = null;
            }
            return;
        }else if (del.left == null) {
            //如果只有一个右子节点，则用右子节点代替该节点
            if (isRightChild) {
                parent.right = del.right;
            }else {
                parent.left = del.right;
            }
            return;
        }else if (del.right == null) {
            //如果只有一个左子节点，则用左子节点代替该节点
            if (isRightChild) {
                parent.right = del.left;
            }else {
                parent.left = del.left;
            }
            return;
        }else {
            //左右子节点均存在，使用后继节点替换
            Node successor = getSuccessor(del);
            int succData = successor.data;
            remove(succData);
            del.data = succData;//节点位置不动，把值更新为后继节点的值。后继节点必为叶子节点
        }
    }

    public static void main(String[] args){
        preOrder(ConstSamples.bstSample.root);
        System.out.println();
        travPre(ConstSamples.bstSample.root);
        System.out.println();
//        levelOrder(ConstSamples.bstSample.root);
//        System.out.println();
        inOrder(ConstSamples.bstSample.root);
        System.out.println();
        travIn(ConstSamples.bstSample.root);
        System.out.println();
        postOrder(ConstSamples.bstSample.root);
        System.out.println();
        travPost(ConstSamples.bstSample.root);
//        ConstSamples.bstSample.remove(28);
//        inOrder(ConstSamples.bstSample.root);
//        System.out.println();
//        preOrder(ConstSamples.bstSample.root);
    }

}
