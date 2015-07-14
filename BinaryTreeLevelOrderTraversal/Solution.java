/*
  https://leetcode.com/problems/binary-tree-level-order-traversal/

  Binary Tree Level Order Traversal

  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

  For example:
  Given binary tree {3,9,20,#,#,15,7},
  3
  / \
  9  20
  /  \
  15   7
  return its level order traversal as:
  [
  [3],
  [9,20],
  [15,7]
  ]
  confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

*/

import java.util.*;

public class Solution {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 0;
        int sum = 1;
        queue.add(root);
        List<Integer> first = new ArrayList<Integer>();
        first.add(root.val);
        result.add(first);

        while (!queue.isEmpty()) {
            depth ++;

            int nextSum = 0;
            List<Integer> next = new ArrayList<Integer>();
            for (int i = 0; i < sum; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    nextSum ++;
                    queue.add(node.left);
                    next.add(node.left.val);
                }

                if (node.right != null) {
                    nextSum ++;
                    queue.add(node.right);
                    next.add(node.right.val);
                }
            }
            sum = nextSum;
            if (next.size() != 0) {
                result.add(next);
            }
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();

        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        List<List<Integer>> result = s.levelOrder(a);

        for (List<Integer> list : result) {
            System.out.println("");
            for (Integer i : list) {
                System.out.print(" " + i);
            }
            System.out.println("");
        }
    }
}
