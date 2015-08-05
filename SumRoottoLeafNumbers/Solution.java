/*
  The root-to-leaf path 1->2 represents the number 12.
  The root-to-leaf path 1->3 represents the number 13.

  Return the sum = 12 + 13 = 25.

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

    public int sumNumbers(TreeNode root) {
        if ( root == null ) {
            return 0;
        }

        Integer sum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        Queue<Integer> prefix_queue = new LinkedList<Integer>();
        prefix_queue.offer(0);

        while (! queue.isEmpty()) {
            Queue<TreeNode> temp_queue = new LinkedList<TreeNode>();
            Queue<Integer> temp_prefix_queue = new LinkedList<Integer>();
            while (! queue.isEmpty()) {
                TreeNode node = queue.poll();
                Integer prefix = prefix_queue.poll() * 10 + node.val;

                if (node.left == null && node.right == null) {
                    sum += prefix;
                } else {
                    if (node.left != null) {
                        temp_queue.offer(node.left);
                        temp_prefix_queue.offer(prefix);
                    }

                    if (node.right != null) {
                        temp_queue.offer(node.right);
                        temp_prefix_queue.offer(prefix);
                    }
                }
            }

            queue = temp_queue;
            prefix_queue = temp_prefix_queue;
        }

        return sum;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        System.out.println("25 : " + s.sumNumbers(a));
    }
}
