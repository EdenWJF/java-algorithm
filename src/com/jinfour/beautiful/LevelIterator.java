package com.jinfour.beautiful;

import java.util.LinkedList;

public class LevelIterator {

    public void levelIterator(BiTree root) {
        if (root == null)
            return;

        LinkedList<BiTree> queue = new LinkedList<BiTree>();
        BiTree current = null;
        queue.offer(root);//将根节点入队
        while (!queue.isEmpty()) {
            current = queue.poll();//出队队头元素并且访问
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

    }

    private class BiTree {

        String data;
        BiTree left;
        BiTree right;
    }
}
