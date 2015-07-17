/*
  https://leetcode.com/problems/symmetric-tree/

  Symmetric Tree

  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

  For example, this binary tree is symmetric:

  1
  / \
  2   2
  / \ / \
  3  4 4  3
  But the following is not:
  1
  / \
  2   2
  \   \
  3    3
  Note:
  Bonus points if you could solve it both recursively and iteratively.

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        if (root.left != null) {
            leftStack.push(root.left);
        }

        if (root.right != null) {
            rightStack.push(root.right);
        }

        while (! leftStack.empty() && ! rightStack.empty()) {
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();

            if (left.val != right.val) {
                return false;
            }

            if (left.left != null && right.right != null) {
                leftStack.push(left.left);
                rightStack.push(right.right);
            } else if ( ! (left.left == null && right.right == null) ) {
                return false;
            }


            if (left.right != null && right.left != null) {
                leftStack.push(left.right);
                rightStack.push(right.left);
            } else if ( ! (left.right == null && right.left == null) ) {
                return false;
            }
        }

        if (leftStack.empty() && rightStack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);

        a.left = b;
        a.right = c;
        b.left = f;
        b.right = g;
        c.left = d;
        c.right = e;

        System.out.println("true : " + s.isSymmetric(a));


        TreeNode a2 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode c2 = new TreeNode(2);
        TreeNode d2 = new TreeNode(3);
        TreeNode g2 = new TreeNode(3);

        a2.left = b2;
        a2.right = c2;
        b2.right = g2;
        c2.right = d2;
        System.out.println("false : " + s.isSymmetric(a2));

    }
}
