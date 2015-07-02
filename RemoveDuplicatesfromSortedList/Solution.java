/*
  https://leetcode.com/problems/remove-duplicates-from-sorted-list/

  Remove Duplicates from Sorted List

  Given a sorted linked list, delete all duplicates such that each element appear only once.

  For example,
  Given 1->1->2, return 1->2.
  Given 1->1->2->3->3, return 1->2->3.

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            if (pre.equals(dummy) || pre.val != head.val){
                pre = head;
                head = head.next;
            } else {
                pre.next = head.next;
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(s.listNode2Str(a));
        ListNode node = s.deleteDuplicates(a);
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
