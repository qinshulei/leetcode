/*
https://leetcode.com/problems/binary-search-tree-iterator/

Binary Search Tree Iterator

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

*/

import java.util.*;

public class BSTIterator {

    /**
     * Definition for binary tree
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ! stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode root = stack.pop();
        if( root.right != null){
            TreeNode next = root.right;
            while (next != null) {
                stack.push(next);
                next = next.left;
            }
        }
        return root.val;
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        b.left = a;
        b.right = c;

        BSTIterator iterator = new BSTIterator(b);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
