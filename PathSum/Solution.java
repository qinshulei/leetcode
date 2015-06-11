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

  不要熬夜，坑自己。头脑不清，各种莫名其妙的错误。
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
        if (root == null){
            return false;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> sumStack = new Stack<Integer>();
        stack.push(root);
        sumStack.push(sum);

        while(!stack.empty()) {
            TreeNode cur = stack.pop();
            int curSum = sumStack.pop();
            int left = curSum - cur.val;
            if (cur.left == null && cur.right == null) {
                if (left == 0) {
                    return true;
                }
            }

            if (cur.right!=null){
                stack.push(cur.right);
                sumStack.push(left);
            }

            if (cur.left!=null) {
                stack.push(cur.left);
                sumStack.push(left);
            }
        }

        return false;
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

        System.out.println("true : " + s.hasPathSum(a, 9));


        TreeNode aa = new TreeNode(1);
        TreeNode bb = new TreeNode(2);
        aa.left = bb;

        System.out.println("false : " + s.hasPathSum(aa, 0));

    }
}
