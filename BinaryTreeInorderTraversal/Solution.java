/*
  https://leetcode.com/problems/binary-tree-inorder-traversal/

  Binary Tree Inorder Traversal

  Given a binary tree, return the inorder traversal of its nodes' values.

  For example:
  Given binary tree {1,#,2,3},
  1
  \
  2
  /
  3
  return [1,3,2].

  Note: Recursive solution is trivial, could you do it iteratively?

  confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

  上课没认真听讲，中序徧历居然是第一次自己写，这个方法自己想还真没想出来，
  把所有左子树都先入栈的思路还是很有启发的。有点像链表的徧历感觉，然后又充份接合乐栈的特性。
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.empty()) {
                return result;
            }

            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;

        List<Integer> result = s.inorderTraversal(a);

        System.out.print(" 1 3 2 : ");
        for (Integer i : result) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }
}
