/*
  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

  Lowest Common Ancestor of a Binary Search Tree

  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

  According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

  _______6______
  /              \
  ___2__          ___8__
  /      \        /      \
  0      _4       7       9
  /  \
  3   5
  For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if ( (p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val) ) {
                return root;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
        }
        return null;
    }

    public static void main(String[] args){
        Solution s = new Solution();

        TreeNode a = new TreeNode(6);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(8);
        TreeNode c1 = new TreeNode(0);
        TreeNode c2 = new TreeNode(4);
        TreeNode c3 = new TreeNode(7);
        TreeNode c4 = new TreeNode(9);
        TreeNode d1 = new TreeNode(3);
        TreeNode d2 = new TreeNode(5);

        a.left = b1;
        a.right = b2;
        b1.left = c1;
        b1.right = c2;
        b2.left = c3;
        b2.right = c4;
        c1.left = d1;
        c1.right = d2;

        System.out.println("2 : " + s.lowestCommonAncestor(a,b1,c2).val);
        System.out.println("6 : " + s.lowestCommonAncestor(a,b1,b2).val);
    }
}
