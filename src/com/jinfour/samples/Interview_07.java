package com.jinfour.samples;

import java.util.Arrays;

public class Interview_07 {


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    /**
     * 递归！
     * [preStart + 1, preStart + i - inStart]是前序序列中左子树封闭区间
     * [preStart + i - inStart + 1, preEnd]是前序序列中右子树封闭区间
     *
     * [inStart, i - 1]是中序序列中左子树封闭区间
     * [i + 1, inEnd]是中序序列中右子树封闭区间
     *
     * @param pre 前序序列
     * @param preStart 前序序列封闭区间的左指针
     * @param preEnd   前序序列封闭区间的右指针
     * @param in  中序序列
     * @param inStart 中序序列封闭区间的左指针
     * @param inEnd   中序序列封闭区间的右指针
     * @return  树的根结点
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        // 还有子数组就继续递归，不存在子数组了（表现为end > start）,就返回空子树给父结点
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
            }
        }
        return root;
    }

    public static void main(String[] args){
        int[] preorder = new int[]{1,2,4,7,3,5,6,8};
        int[] inorder = new int[]{4,7,2,1,5,3,8,6};
        //int[] node = Arrays.copyOfRange(preorder, 0, 1);
        TreeNode node = new Interview_07().reConstructBinaryTree(preorder, inorder);
        System.out.println(node);
    }

}
