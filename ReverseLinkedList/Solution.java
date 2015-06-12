/*
  https://leetcode.com/problems/reverse-linked-list/

  Reverse Linked List

  Reverse a singly linked list.

  click to show more hints.

  Hint:
  A linked list can be reversed either iteratively or recursively. Could you implement both?

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

    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        while (head != null){
            ListNode node = head.next;
            head.next = preNode;
            preNode = head;
            head = node;
        }
        return preNode;
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
        System.out.println(s.listNode2Str(a));
        ListNode node = s.reverseList(a);
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
