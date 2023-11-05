package com.jinfour;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Test {

    static int a = 4;


    public static void main(String[] args) {
        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s));
        Test t = new Test();
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
        Calendar initdate = Calendar.getInstance();
        initdate.add(Calendar.WEEK_OF_YEAR, -1);
        Calendar enddate = Calendar.getInstance();
        enddate.add(Calendar.MINUTE, 5);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String where = "booked = 0 and bookdate > '" + sdf.format(initdate.getTime()) + "'  and bookdate < '" + sdf.format(enddate.getTime()) + "'";

        System.out.println(where);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        inorder(root, res);
        return res;
    }

    void inorder(TreeNode node, LinkedList list) {
        if (node.left != null) inorder(node.left, list);
        list.offer(node.val);
        if (node.right != null) inorder(node.right, list);
    }

    void sleep() {
        System.out.println("sssss");
    }


}
