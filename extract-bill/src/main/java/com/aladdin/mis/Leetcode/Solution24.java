package com.aladdin.mis.Leetcode;

/**
 * 删除链表重复数据
 */
public class Solution24 {

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
        ListNode data = swapPairs(head);
        while (data != null){
            System.out.println(data.val);
            data = data.next;
        }
        System.out.println();

    }

    /**
     *
     * @param head
     * @return
     */
    private static ListNode swapPairs(ListNode head) {
        return null;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
