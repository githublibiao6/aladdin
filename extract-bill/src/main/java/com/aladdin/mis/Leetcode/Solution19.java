package com.aladdin.mis.Leetcode;

/**
 * 删除链表的倒数第 N 个结点
 *
 * 双指针
 */
public class Solution19 {

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2, node);
        ListNode root = new ListNode(1, node1);
        ListNode result = removeNthFromEnd(root, 1);
        while (result != null){
            System.err.println(result.val);
            result = result.next;
        }
    }


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
