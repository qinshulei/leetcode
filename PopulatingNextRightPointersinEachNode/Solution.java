/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

Populating Next Right Pointers in Each Node

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

*/

import java.util.*;

public class Solution {

    /**
     * Definition for binary tree with next pointer.
     */
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }


    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int nums = 1;

        while (! queue.isEmpty()) {
            int record_num = 0;
            for (int i = 0; i < nums; i++) {
                TreeLinkNode node = queue.poll();
                if (i != nums - 1) {
                    node.next = queue.peek();
                }

                if( node.left != null ){
                    queue.add(node.left);
                    record_num ++;
                }

                if ( node.right != null ){
                    queue.add(node.right);
                    record_num ++;
                }
            }
            nums = record_num;
        }
    }

    public static void main(String[] args){

    }
}
