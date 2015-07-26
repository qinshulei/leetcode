/*
  https://leetcode.com/problems/binary-tree-preorder-traversal/

  Binary Tree Preorder Traversal

  Given a binary tree, return the preorder traversal of its nodes' values.

  For example:
  Given binary tree {1,#,2,3},
  1
  \
  2
  /
  3
  return [1,2,3].

  Note: Recursive solution is trivial, could you do it iteratively?

  这也是中级难度，，很多初级难度的题目就已经用先序徧历了好不好。
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if ( root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(! stack.empty()) {
            TreeNode current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }


    public static void main(String[] args){
        Solution s = new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;

        List<Integer> result = s.preorderTraversal(a);
        System.out.print(" 1 2 3 : ");
        for (Integer i : result) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }
}
