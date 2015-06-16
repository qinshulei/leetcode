/*
  Invert Binary Tree

  Invert a binary tree.

  4
  /   \
  2     7
  / \   / \
  1   3 6   9
  to
  4
  /   \
  7     2
  / \   / \
  9   6 3   1

  运动过后做题效果真差，以后还是先做题在运动吧。不然大脑充血，很鲁莽。

*/

import java.util.*;

public class Solution {


    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root != null) {
            stack.push(root);
        }

        while(! stack.empty()){
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        return root;
    }

    public static void main(String[] args){

    }
}
