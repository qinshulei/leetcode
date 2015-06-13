/*
  https://leetcode.com/problems/reverse-linked-list-ii/

  Reverse Linked List II

  Total Accepted: 41245 Total Submissions: 158195 My Submissions Question Solution
  Reverse a linked list from position m to n. Do it in-place and in one-pass.

  For example:
  Given 1->2->3->4->5->NULL, m = 2 and n = 4,

  return 1->4->3->2->5->NULL.

  Note:
  Given m, n satisfy the following condition:
  1 ≤ m ≤ n ≤ length of list.

*/

import java.util.*;

public class Solution {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode startNode = head;
        ListNode startNodeEnd = null;
        for (int i = 1; i < m; i++ ) {
            startNodeEnd = head;
            head = head.next;
        }

        ListNode midStartNode = head;

        ListNode midPreviousNode = null;
        for (int i = 0; i <= n - m ; i ++ ) {
            ListNode node = head.next;
            head.next = midPreviousNode;
            midPreviousNode = head;
            head = node;
        }

        if (head != null){
            midStartNode.next = head;
        }

        if (startNodeEnd != null) {
            startNodeEnd.next = midPreviousNode;
        }

        if (startNodeEnd != null) {
            return startNode;
        } else {
            return midPreviousNode;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(s.listNode2Str(a));
        ListNode node = s.reverseBetween(a, 2, 4);
        System.out.println(s.listNode2Str(node));

    }

    private String listNode2Str(ListNode node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val);
            node = node.next;
        }
        return builder.toString();
    }
}
