package com.jinfour.tree;

import com.jinfour.tree.BinarySearchTree;

import java.util.HashMap;
import java.util.TreeMap;

public class AVLTree extends BinarySearchTree {

    public AVLTree() {

    }

    /**
     * AVL树：
     *      任何一个节点的左子支高度与右子支高度之差的绝对值不超过1。需要我们注意的是，AVL树定义不是说从根节点到叶子节点的最短距离比最长短距离大1
     */

    @Override
    public Node insert0(Node node, int e) {
//        System.out.println("in AVL");
        if (node == null) {
            node = new Node(e);
            node.height = 0;
        }else {
            if (e < node.data) {
                //递归到左子树
                node.left = insert0(node.left, e);
                if (height(node.left) - height(node.right) == 2) {
                    if (e < node.left.data) {
                        node = leftLeftRotation(node);
                    }else {
                        node = leftRightRotation(node);
                    }
                }
            }else if (e > node.data){
                node.right = insert0(node.right, e);
                if (height(node.right) - height(node.left) == 2) {
                    if (e > node.right.data) {
                        node = rightRightRotation(node);
                    }else {
                        node = rightLeftRotation(node);
                    }
                }
            }else {
                System.out.println("添加失败，重复添加");
                return null;
            }
        }
        node.height = max(height(node.left), height(node.right)) + 1;
        return node;
    }
    /*
     * 比较两个值的大小
     */
    private int max(int a, int b) {
        return Math.max(a, b);
    }


    private Node leftLeftRotation(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        leftChild.setHeight(max(height(leftChild.left), height(leftChild.right)) + 1);
        node.setHeight(max(height(node.left), height(node.right)) + 1);
        return leftChild;
    }

    private int height(Node node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    private Node rightRightRotation(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        rightChild.setHeight(max(height(rightChild.left), height(rightChild.right)) + 1);
        node.setHeight(max(height(node.left), height(node.right)) + 1);
        return rightChild;
    }


    private Node rightLeftRotation(Node node) {
        node.right = leftLeftRotation(node.right);
        return rightRightRotation(node);
    }

    private Node leftRightRotation(Node node) {
        node.left = rightRightRotation(node.left);
        return leftLeftRotation(node);
    }

    @Override
    public void remove(int e) {
        remove0(root, e);
    }

    public Node remove0(Node cur, int e) {
        if (cur == null) {
            return null;
        }
        if (cur.data == e) {
            //如果当前节点就是指定要删除的
            //判断当前节点的子节点情况
            if (cur.left != null && cur.right != null) {
                Node tmp;
                if (height(cur.left) > height(cur.right)) {
                    //如果左子树高度大于右子树
                    //就在左子树中找最大的值
                    tmp = cur.left;
                    while (tmp.right != null) {
                        tmp = tmp.right;
                    }
                    cur.data = tmp.data;
                    remove0(tmp, tmp.data);
                }else {
                    tmp = cur.right;
                    while (tmp.left != null) {
                        tmp = tmp.left;
                    }
                    cur.data = tmp.data;
                    remove0(tmp, tmp.data);
                }
            }else if (cur.left != null) {
                //如果左子树不为空，右子树为空，那么左子树只可能是一个叶子节点，因为height < 2
                cur.data = cur.left.data;
                remove0(cur.left, cur.left.data);
            }else if (cur.right != null) {
                cur.data = cur.right.data;
                remove0(cur.right, cur.right.data);
            }else {
                //子树为空的情况下，直接删除该叶子节点
                cur = null;
            }
        }else if (cur.data > e) {
            //如果当前节点值大于e，则进入当前节点的左子树
            cur.left = remove0(cur.left, e);
            if (height(cur.right) - height(cur.left) == 2) {
                Node right = cur.right;
                if (height(right.right) > height(right.left)) {
                    cur = leftLeftRotation(cur);
                }else {
                    cur = leftRightRotation(cur);
                }
            }
        }else {
            //如果当前节点值小于e，则进入当前节点的右子树
            cur.right = remove0(cur.right, e);
            if (height(cur.left) - height(cur.right) == 2) {
                Node left = cur.left;
                if (height(left.left) > height(left.right)) {
                    cur = leftLeftRotation(cur);
                }else {
                    cur = leftRightRotation(cur);
                }
            }
        }
        return cur;
    }

    public static void main(String[] args){
        ConstSamples.avlSample.remove(8);
        levelOrder(ConstSamples.avlSample.root);
    }
}
