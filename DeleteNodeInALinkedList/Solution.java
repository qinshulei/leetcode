/*
  https://leetcode.com/problems/delete-node-in-a-linked-list/

  Delete Node in a Linked List

  Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

  Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

  WTF 我一度觉得这题无解，看了讨论，说 change the value,简直惊呆了。心里万千草拟马奔腾。
  做了太多链表的题目，习惯了改变上一个指针的引用来删除节点。完全没想到可以改变当前指针的值来跳过一个节点。
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

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args){

    }
}
