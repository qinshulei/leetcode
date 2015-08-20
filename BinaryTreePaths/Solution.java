/*
  https://leetcode.com/problems/binary-tree-paths/

  Binary Tree Paths

  Given a binary tree, return all root-to-leaf paths.

  For example, given the following binary tree:

  1
  /   \
  2     3
  \
  5
  All root-to-leaf paths are:

  ["1->2->5", "1->3"]



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

    public List<String> binaryTreePaths(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<String> str_queue = new LinkedList<String>();
        List<String> result = new ArrayList<String>();

        if (root != null) {
            queue.add(root);
            str_queue.add("");
        }

        while(! queue.isEmpty()){
            TreeNode node = queue.poll();
            String temp = str_queue.poll();
            temp = "".equals(temp) ? "" + node.val : temp + "->" + node.val;

            if (node.left != null) {
                queue.add(node.left);
                str_queue.add(temp);
            }

            if (node.right != null) {
                queue.add(node.right);
                str_queue.add(temp);
            }

            if (node.left == null && node.right == null) {
                result.add(temp);
            }
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.right = d;

        List<String> list = s.binaryTreePaths(a);
        for (String temp : list) {
            System.out.println(temp);
        }
    }
}
