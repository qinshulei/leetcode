/*
  https://leetcode.com/problems/merge-two-sorted-lists/

  Merge Two Sorted Lists

  Merge two sorted linked lists and return it as a new list.
  The new list should be made by splicing together the nodes of the first two lists.


  看了人家的答案，普遍使用了一个dummy node去做为链表头。
  使得逻辑一下子简单不少。 https://leetcode.com/discuss/33783/my-10-line-clean-c-code
  我没有dummy node，所以不得不考虑三种情况，代码逻辑就显得比较复杂。也容易出错。
  就和做几何证明题一样，构造一些新的变量，可以将一些不同的情况统一成同一种情况。
  使得代码逻辑变得更容易理解。这题还是挺有收获的。
*/

import java.util.*;

public class Solution {

    /*
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }
        ListNode head = l1;

        ListNode l1_p = l1;
        ListNode l2_p = l2;
        ListNode pre_l1_p = null;
        ListNode next_l2_p = null;
        while(l2_p != null) {
            next_l2_p = l2_p.next;
            while ( l1_p != null && l1_p.val <= l2_p.val ){
                pre_l1_p = l1_p;
                l1_p = l1_p.next;
            }

            if (pre_l1_p == null) {
                l2_p.next = l1_p;
                head = l2_p;
                pre_l1_p = l2_p;
            } else if (l1_p == null) {
                pre_l1_p.next = l2_p;
                return head;
            } else {
                pre_l1_p.next = l2_p;
                l2_p.next = l1_p;
                pre_l1_p = l2_p;
            }
            l2_p = next_l2_p;
        }

        return head;
    }

    public static void main(String[] args){

    }
}
