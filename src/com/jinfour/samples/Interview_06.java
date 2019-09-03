package com.jinfour.samples;

public class Interview_06 {

    //从尾到头打印链表

    static class ListNode {
        String data;

        ListNode next;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode(String data) {
            this.data = data;
        }
    }


    static void printNode(ListNode node) {
        if (node.next != null) {
            printNode(node.next);
        }
        System.out.println(node.data);
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode("c");
        ListNode node2 = new ListNode("b");node2.next = node1;
        ListNode node3 = new ListNode("a");node3.next = node2;

        printNode(node3);

    }
}
