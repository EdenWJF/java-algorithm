package com.jinfour._linkedlist.reverselist;

import com.jinfour._linkedlist.ListNode;

public class ReverseBetween {

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0 ; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode p = prev.next;

        while(n - m > 0) {
            ListNode q = p.next;
            p.next = q.next;
            q.next = prev.next;
            prev.next = q;
            m++;
        }

        return dummy.next;

    }
}
