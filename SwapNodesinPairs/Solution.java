/*
  https://leetcode.com/problems/swap-nodes-in-pairs/

  Swap Nodes in Pairs

  Given a linked list, swap every two adjacent nodes and return its head.

  Fonnr example,
  Given 1->2->3->4, you should return the list as 2->1->4->3.

  Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null && head.next != null) {
            ListNode next = head.next;
            ListNode next_next = next.next;
            pre.next = next;
            next.next = head;
            head.next = next_next;
            pre = head;
            head = next_next;
        }
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
        System.out.println(s.listNode2Str(s.swapPairs(a)));
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
