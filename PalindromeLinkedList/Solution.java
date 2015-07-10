/*
  https://leetcode.com/problems/palindrome-linked-list/

  Palindrome Linked List

  Given a singly linked list, determine if it is a palindrome.

  Follow up:
  Could you do it in O(n) time and O(1) space?

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

    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            ListNode next_slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;

                slow.next = dummy.next;
                dummy.next = slow;
            } else if ( fast.next == null) {
                fast = null;
            }
            slow = next_slow;

            //System.out.println("dummy : " + listNode2Str(dummy));
        }


        ListNode start = dummy.next;
        //System.out.println("" + listNode2Str(start));
        //System.out.println("" + listNode2Str(slow));
        while ( slow != null ) {
            if ( start.val != slow.val ) {
                return false;
            }

            start = start.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args){

        Solution s = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode f = new ListNode(4);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        a.next = b;

        b.next = f;
        f.next = c;

        c.next = d;

        System.out.println("true : " + s.isPalindrome(a));
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
