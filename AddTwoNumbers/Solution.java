/*
  https://leetcode.com/problems/add-two-numbers/

  Add Two Numbers Total Accepted: 62611 Total Submissions: 290766 My Submissions Question Solution
  You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  Output: 7 -> 0 -> 8

*/

import java.util.*;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode result = null;
        boolean flag = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (flag) {
                sum += 1;
                flag = false;
            }
            if (sum >= 10) {
                flag = true;
                sum = sum - 10;
            }
            if (result == null) {
                result = new ListNode(sum);
                head = result;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }
            l1=l1.next;
            l2=l2.next;
        }
        ListNode elseList = l1;
        if(l1 == null) {
            elseList = l2;
        }
        while (elseList != null) {
            int sum = elseList.val;
            if (flag) {
                sum += 1;
                flag = false;
            }
            if (sum >= 10) {
                flag = true;
                sum = sum - 10;
            }
            if (result == null) {
                result = new ListNode(sum);
                head = result;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }
            elseList = elseList.next;
        }
        if(flag)
            {
                result.next = new ListNode(1);
            }
        return head;
    }

    public static void main(String[] args) {

    }
}
