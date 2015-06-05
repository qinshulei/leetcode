/*
  https://leetcode.com/problems/linked-list-cycle/

  Linked List Cycle

  Given a linked list, determine if it has a cycle in it.

  Follow up:
  Can you solve it without using extra space?

*/

import java.util.*;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode cursor = head;
        ListNode index = head;
        while(index != null){
            if (index.equals(index.next)) {
                return true;
            }

            cursor = head;
            while (cursor != null && ! cursor.equals(index)) {
                //System.out.println( "index : " + index.val + " ---- cursor : " + cursor.val);
                if (cursor.equals(index.next)){
                    return true;
                }
                cursor = cursor.next;
            }

            index = index.next;
        }
        return false;
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


        System.out.println( "false : " + s.hasCycle(a) );
        d.next = c;
        System.out.println( "true : " + s.hasCycle(a) );
    }
}
