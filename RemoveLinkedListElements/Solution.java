/*
  https://leetcode.com/problems/remove-linked-list-elements/

  Remove Linked List Elements

  Remove all elements from a linked list of integers that have value val.

  Example
  Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
  Return: 1 --> 2 --> 3 --> 4 --> 5

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

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            ListNode next = head.next;
            if (head.val == val) {
                pre.next = next;
            } else {
                pre = head;
            }

            head = next;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        Solution s = new Solution();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        System.out.println(" 1 --> 2 --> 3 --> 4 --> 5 : " + s.printListNode(s.removeElements(a, 6)));
    }

    private String printListNode(ListNode head){
        StringBuilder builder = new StringBuilder();
        while (head!=null) {
            builder.append( " " + head.val );
            head = head.next;
        }
        return builder.toString();
    }
}
