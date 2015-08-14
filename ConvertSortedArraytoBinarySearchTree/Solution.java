/*
  https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

  Convert Sorted Array to Binary Search Tree

  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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

    public static class Range {
        int start;
        int end;
        int mid;
        Range(int start, int end) {
            this.start = start;
            this.end = end;
            this.mid = (start + end) / 2;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0){
            return null;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Range> rangeQueue = new LinkedList<Range>();
        Range range = new Range(0, nums.length - 1);
        TreeNode head = new TreeNode(nums[range.mid]);
        nodeQueue.add(head);
        rangeQueue.add(range);

        while (! nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            Range currentRange = rangeQueue.poll();

            if (currentRange.mid - 1 == currentRange.start) {
                currentNode.left = new TreeNode(nums[currentRange.mid - 1]);
            } else if (currentRange.mid - 1 > currentRange.start) {
                Range leftRange = new Range(currentRange.start,currentRange.mid - 1);
                currentNode.left = new TreeNode(nums[leftRange.mid]);
                nodeQueue.add(currentNode.left);
                rangeQueue.add(leftRange);
            }

            if (currentRange.mid + 1 == currentRange.end) {
                currentNode.right = new TreeNode(nums[currentRange.mid + 1]);
            } else if (currentRange.mid + 1 < currentRange.end) {
                Range rightRange = new Range(currentRange.mid + 1,currentRange.end);
                currentNode.right = new TreeNode(nums[rightRange.mid]);
                nodeQueue.add(currentNode.right);
                rangeQueue.add(rightRange);
            }
        }

        return head;
    }


    public static void main(String[] args){
        int[] test = new int[]{1,2,3,4,5,6,7,8,9};
        Solution s = new Solution();
        TreeNode out = s.sortedArrayToBST(test);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(out);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(" " + node.val);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
