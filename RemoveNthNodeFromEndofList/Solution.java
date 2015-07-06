/*
  https://leetcode.com/problems/remove-nth-node-from-end-of-list/

  Remove Nth Node From End of List

  Given a linked list, remove the nth node from the end of list and return its head.

  For example,

  Given linked list: 1->2->3->4->5, and n = 2.

  After removing the second node from the end, the linked list becomes 1->2->3->5.
  Note:
  Given n will always be valid.
  Try to do this in one pass.

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < n; i++) {
            head = head.next;
        }

        while(head.next != null){
            head = head.next;
            pre = pre.next;
        }

        pre.next = pre.next.next;

        return dummy.next;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;

        ListNode node = s.removeNthFromEnd(a, 2);
        System.out.println("1 2 4 : " + s.listNode2Str(node));
    }

    private String listNode2Str(ListNode node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(" " + node.val);
            node = node.next;
        }
        return builder.toString();
    }
}
