package com.aladdin.mis.learn.leetcode;

import java.util.*;

/**
 * 二叉树的中序遍历
 */
public class Solution94 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(2, node, null);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(inorderTraversal(root));

    }


    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        handNode(queue, root);
        while (!queue.isEmpty()){
            TreeNode s = queue.peek();
            if(s != null){
                list.add(s.val);
            }
            queue.poll();
        }
        return list;
    }

    private static void handNode(Queue<TreeNode> queue , TreeNode node){
        if(node == null){
            return;
        }
        handNode(queue, node.left);
        queue.offer(node);
        handNode(queue, node.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

}
