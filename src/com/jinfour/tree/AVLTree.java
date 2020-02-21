package com.jinfour.tree;

import java.util.HashMap;
import java.util.TreeMap;

public class AVLTree extends BinarySearchTree{

    /**
     * AVL树：
     *      任何一个节点的左子支高度与右子支高度之差的绝对值不超过1。需要我们注意的是，AVL树定义不是说从根节点到叶子节点的最短距离比最长短距离大1
     */

    static class Entry extends Node {
        int height;
        Entry parent;

        public Entry(int n) {
            super(n);
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    @Override
    public void insert(int e) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("a", 1);
    }

    @Override
    public void remove(int e) {

    }
}
