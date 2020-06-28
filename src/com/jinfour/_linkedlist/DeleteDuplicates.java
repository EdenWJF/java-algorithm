package com.jinfour._linkedlist;

public class DeleteDuplicates {

    //删除链表中重复出现的节点
    ListNode solution(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode tmp = cur.next;
                while(tmp.next != null && tmp.val == tmp.next.val) {
                    tmp = tmp.next;
                }
                cur.next = tmp.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    ListNode retry(ListNode head) {
        return null;
    }
}
