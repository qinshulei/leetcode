/*
  https://leetcode.com/problems/intersection-of-two-linked-lists/

  Intersection of Two Linked Lists

  Write a program to find the node at which the intersection of two singly linked lists begins.


  For example, the following two linked lists:

  A:          a1 → a2
                      ↘
                       c1 → c2 → c3
                      ↗
  B:     b1 → b2 → b3
  begin to intersect at node c1.

  Notes:
  If the two linked lists have no intersection at all, return null.
  The linked lists must retain their original structure after the function returns.
  You may assume there are no cycles anywhere in the entire linked structure.
  Your code should preferably run in O(n) time and use only O(1) memory.
  Credits:
  Special thanks to @stellari for adding this problem and creating all test cases.
*/

import java.util.*;

public class Solution {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<ListNode>();
        Stack<ListNode> stackB = new Stack<ListNode>();

        while(headA != null){
            stackA.push(headA);
            headA = headA.next;
        }

        while(headB != null){
            stackB.push(headB);
            headB = headB.next;
        }

        ListNode lastA = null;
        ListNode lastB = null;

        while (!stackA.empty() && !stackB.empty()) {
            ListNode currentA = stackA.pop();
            ListNode currentB = stackB.pop();
            if ( currentA != currentB ) {
                if (lastA == null && lastB == null){
                    return null;
                } else {
                    return lastA;
                }
            }
            lastA = currentA;
            lastB = currentB;
        }

        return lastA;
    }

    public static void main(String[] args){
        Solution s = new Solution();

        ListNode a1 = new ListNode(0);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode b4 = new ListNode(6);
        ListNode c1 = new ListNode(7);
        ListNode c2 = new ListNode(8);
        ListNode c3 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = c1;
        c1.next = c2;
        c2.next = c3;

        ListNode out = s.getIntersectionNode(a1,b1);
        System.out.println("7 : " + out.val);

    }
}
