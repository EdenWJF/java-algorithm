package com.jinfour._linkedlist;

public class MergeKLists {

    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode list3 = new ListNode(4);
        list3.next = new ListNode(7);
        list3.next.next = new ListNode(9);
        ListNode[] lists = new ListNode[]{list1, list2, list3};

//        ListNode listNode = merge2Lists(list1, list2);
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        /**************************************/
        if (lists == null) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return merge2Lists(lists[1], lists[0]);
        }
        /**************************************/

        ListNode[] low = new ListNode[lists.length/2];
        ListNode[] high = new ListNode[lists.length - lists.length/2];

        for (int i = 0; i < lists.length; i++) {
            if (i < lists.length/2) low[i] = lists[i];
            if (i >= lists.length/2) high[i - lists.length/2] = lists[i];
        }
        return merge2Lists(mergeKLists(low), mergeKLists(high));
    }

    public static ListNode merge2Lists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while(list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    tmp.next = list2;
                    list2 = list2.next;
                }else {
                    tmp.next = list1;
                    list1 = list1.next;
                }
            }else if (list1 == null) {
                tmp.next = list2;
                list2 = list2.next;
            }else {
                tmp.next = list1;
                list1 = list1.next;
            }
            tmp = tmp.next;
        }
        return res.next;
    }
}
