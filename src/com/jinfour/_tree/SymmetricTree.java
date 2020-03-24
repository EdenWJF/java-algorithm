package com.jinfour._tree;

import java.util.LinkedList;

public class SymmetricTree {

    public static void main(String[] args){

    }

    public static boolean isSymmetric1(BinarySearchTree.Node t1, BinarySearchTree.Node t2) {

        if(t1 == null &&  t2 ==null) return true;
        if(t1 == null || t2 == null) return false;

        return t1.data == t2.data && isSymmetric1(t1.left, t2.right) && isSymmetric1(t1.right, t2.left);
    }

    public static boolean isSymmetric2(BinarySearchTree.Node t1, BinarySearchTree.Node t2) {

        LinkedList<Integer> list = new LinkedList<>();
        return true;
    }
}
