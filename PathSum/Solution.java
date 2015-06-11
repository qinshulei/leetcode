/*
  https://leetcode.com/problems/path-sum/

  Path Sum

  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

  For example:
  Given the below binary tree and sum = 22,
  5
  / \
  4   8
  /   / \
  11  13  4
  /  \      \
  7    2      1
  return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

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


    public boolean hasPathSum(TreeNode root, int sum) {

        Stack<Node> stack = new Stack<Node>();
        Stack<Integer> sum = new Stack<Node>();



        return false;
    }

    public static void main(String[] args){

    }
}
