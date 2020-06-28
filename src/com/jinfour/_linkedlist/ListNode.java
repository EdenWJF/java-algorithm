package com.jinfour._linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode(int e) {
        this.val = e;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + val +
                ", next=" + next +
                '}';
    }
    public String printf() {
        ListNode t = this;
        String li = "";
        while (t != null) {
            li = li + t.val + "-->";
            t = t.next;
        }
        return li;
    }
}
