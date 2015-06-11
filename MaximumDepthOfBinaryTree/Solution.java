/*
  https://leetcode.com/problems/maximum-depth-of-binary-tree/

  Maximum Depth of Binary Tree

  Given a binary tree, find its maximum depth.

  The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

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


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 0;
        int sum = 1;
        queue.add(root);

        while (!queue.isEmpty()) {
            depth ++;

            int nextSum = 0;
            for (int i = 0; i < sum; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    nextSum ++;
                    queue.add(node.left);
                }

                if (node.right != null) {
                    nextSum ++;
                    queue.add(node.right);
                }
            }
            sum = nextSum;
        }

        return depth;
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
        c.left = d;
        d.left = e;
        d.right = f;
        d.left = g;

        System.out.println("4 : " + s.maxDepth(a));
    }
}
