package com.jinfour._linkedlist;

public class RemoveNthFromEnd {

    //删除链表的倒数第N个节点

    ListNode solution(ListNode head, int n) {
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        ListNode cur = head;
        ListNode pre = cur;
        if (head == null) return null;
        for (; n > 0 && pre.next != null; n--) {
            cur = cur.next;
        }
        if (n != 0) return newHead.next;
        while(cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return newHead.next;
    }

    public static void main(String[] args){
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(4);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(1);
        ListNode h5 = new ListNode(5);
        h1.val = 2;
        h2.val = 4;
        h3.val = 3;
        h4.val = 1;
        h5.val = 5;

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

        ListNode solution = new RemoveNthFromEnd().solution(h1, 2);
        String printf = solution.printf();
        System.out.println(printf);
    }

}
