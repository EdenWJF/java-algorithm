package com.jinfour._linkedlist;

public class ReorderList {
    
    // https://leetcode.cn/problems/reorder-list/ 重排链表

    public void reorderList(ListNode head) {
        // 拆分成两个链表
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        // 反转链表
        ListNode reverse = reverse(fast);

        // 合并链表
        while (reverse != null) {
            ListNode next = reverse.next;
            reverse.next = slow.next;
            slow.next = reverse;
            slow = slow.next.next;
            reverse = next;
        }
    }

    ListNode reverse(ListNode list) {
        ListNode dummy = new ListNode(0);
        ListNode cur = list;
        while(cur != null) {
            ListNode next = list.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
