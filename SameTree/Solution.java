/*
  https://leetcode.com/problems/same-tree/

  Same Tree

  Given two binary trees, write a function to check if they are equal or not.

  Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

*/

import java.util.*;

public class Solution {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> pQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> qQueue = new LinkedList<TreeNode>();
        if (p != null) {
            pQueue.add(p);
        }
        if (q != null) {
            qQueue.add(q);
        }

        while (! pQueue.isEmpty()){
            TreeNode pNode = pQueue.poll();
            if (qQueue.isEmpty()){
                return false;
            }

            TreeNode qNode = qQueue.poll();

            if ( pNode.val != qNode.val){
                return false;
            }

            if (pNode.left != null && qNode.left != null) {
                pQueue.add(pNode.left);
                qQueue.add(qNode.left);
            } else if (pNode.left != null && qNode.left == null) {
                return false;
            } else if (pNode.left == null && qNode.left != null) {
                return false;
            }

            if (pNode.right != null && qNode.right != null) {
                pQueue.add(pNode.right);
                qQueue.add(qNode.right);
            } else if (pNode.right != null && qNode.right == null){
                return false;
            } else if (pNode.right == null && qNode.right != null) {
                return false;
            }
        }

        if (! qQueue.isEmpty()){
            return false;
        }

        return true;
    }

    public static void main(String[] args){

        Solution s = new Solution();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(3);
        TreeNode g = new TreeNode(4);

        a.left = b;
        a.right = c;

        d.left = e;
        d.right = f;

        System.out.println("true : " + s.isSameTree(a, d));
        a.right = g;
        System.out.println("false : " + s.isSameTree(a, d));
    }
}
