package com.jinfour._linkedlist;

public class ListNode {
    int data;
    ListNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode(int e) {
        this.data = e;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
    public String printf() {
        ListNode t = this;
        String li = "";
        while (t != null) {
            li = li + t.data + "-->";
            t = t.next;
        }
        return li;
    }
}
