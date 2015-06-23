/*
  https://leetcode.com/problems/partition-list/

  Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

  You should preserve the original relative order of the nodes in each of the two partitions.

  For example,
  Given 1->4->3->2->5->2 and x = 3,
  return 1->2->2->4->3->5.

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

    public ListNode partition(ListNode head, int x) {
        ListNode dummy_l = new ListNode(0);
        ListNode dummy_h = new ListNode(0);

        ListNode cur_l = dummy_l;
        ListNode cur_h = dummy_h;
        while (head != null){
            if (head.val < x) {
                cur_l.next = head;
                cur_l = head;
            } else {
                cur_h.next = head;
                cur_h = head;
            }

            head = head.next;
        }
        cur_h.next = null;
        cur_l.next = dummy_h.next;

        return dummy_l.next;
    }

    public static void main(String[] args){
        /*
          Given 1->4->3->2->5->2 and x = 3,
          return 1->2->2->4->3->5.
        */

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        Solution s = new Solution();
        System.out.println( " 1->2->2->4->3->5 : " + s.printListNode(s.partition(a, 3)) );

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
