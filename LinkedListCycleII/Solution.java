/*
  https://leetcode.com/problems/linked-list-cycle-ii/

  Linked List Cycle II

  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

  Follow up:
  Can you solve it without using extra space?

  http://fisherlei.blogspot.jp/2013/11/leetcode-linked-list-cycle-ii-solution.html

  这题一开始就感觉道应该是要算出偏移值的，但是数学不好，坑爹的。其实公式也不复杂，老老实实写下来说不定就能够发现规律。

*/

import java.util.*;

public class Solution {
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode deltaNode = head;
        while (deltaNode != slow) {
            slow = slow.next;
            deltaNode = deltaNode.next;
        }

        return deltaNode;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        System.out.println(" 2 : " + s.detectCycle(a).val);
    }
}
