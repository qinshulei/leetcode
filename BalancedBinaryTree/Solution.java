/*

  https://leetcode.com/problems/balanced-binary-tree/

  Balanced Binary Tree

  Given a binary tree, determine if it is height-balanced.

  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

  一开始，错误的理解了平衡树的概念，结果白写了。
  现在完全按照题目描述实现的，不过一大问题是大量对树的深度的重复计算。
  考虑从下向上计算深度，方便复用，不过似乎没有太好的办法
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
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
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(2);
        TreeNode c1 = new TreeNode(3);
        TreeNode c2 = new TreeNode(3);
        TreeNode c3 = new TreeNode(3);
        TreeNode c4 = new TreeNode(3);

        TreeNode d1 = new TreeNode(4);
        TreeNode d2 = new TreeNode(4);
        TreeNode d3 = new TreeNode(4);
        TreeNode d4 = new TreeNode(4);
        TreeNode d5 = new TreeNode(4);
        TreeNode d6 = new TreeNode(4);
        TreeNode d7 = new TreeNode(4);
        TreeNode d8 = new TreeNode(4);

        TreeNode e1 = new TreeNode(5);
        TreeNode e2 = new TreeNode(5);



        a.left = b1;
        a.right = b2;

        b1.left = c1;
        b1.right = c2;

        b2.left = c3;
        b2.right = c4;

        c1.left = d1;
        c1.right = d2;
        c2.left = d3;
        c2.right = d4;
        c3.left = d5;
        c3.right = d6;

        d1.left = e1;
        d1.right = e2;

        System.out.println("true : " + s.isBalanced(a));
    }
}
