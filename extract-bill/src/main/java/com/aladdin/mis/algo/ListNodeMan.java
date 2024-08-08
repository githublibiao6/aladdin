package com.aladdin.mis.algo;

import com.aladdin.mis.Leetcode.Solution19;

/**
 * 删除链表重复数据
 */
public class ListNodeMan {

    public static void main(String[] args) {
        ListNode next4 = new ListNode(5);
        ListNode next3 = new ListNode(4, next4);
        ListNode next2 = new ListNode(4, next3);
        ListNode next1 = new ListNode(3, next2);
        ListNode head = new ListNode(2, next1);
//        while (head != null){
//            System.err.println(head.val);
//            head = head.next;
//        }
        ListNode data = deleteDuplicates(head);
        while (data != null){
            System.out.println(data.val);
            data = data.next;
        }
        System.out.println();

    }

    /**
     * 删除链表，主要是for生成链表
     * @param head 原链表
     * @return 目前链表
     */
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode data = new ListNode(0);
        ListNode result = data;
        int val = -101;
        while (head != null){
            if(val != head.val){
                val = head.val;
                result.next = new ListNode(val);
                result = result.next;
            }
            head = head.next;
        }
        return data.next;
    }

    /**
     * solution 19 删除倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        // 复制结点
        ListNode j = dummyNode;
        ListNode k = dummyNode;

        for (int i = 0; i <= n; i++) {
            k = k.next;
        }

        while (k != null){
            k = k.next;
            j = j.next;
        }

        // 删除节点
        j.next = j.next.next;

        return dummyNode.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
