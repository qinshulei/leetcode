/*
  https://leetcode.com/problems/linked-list-cycle/

  Linked List Cycle

  Given a linked list, determine if it has a cycle in it.

  Follow up:
  Can you solve it without using extra space?

  这题一开始，我还是传统思路，检查cursor的next，是否指向他之前的所有cursor。这样算法基本上就是O(n^2)的程度了。

  然后果断超时了，看了人家的答案，主要思路是 设置一个 移动一步的walker，和一个移动两步的runner。这样如果循环runner总会追上walker.
  这个方法的好处是不会破坏链表。而且复杂度也不过。不过应该也算是trick的技巧了。

  还有一个方法就是标记已经访问过的。然后不断遍历，如果再遇到已经访问过的元素就返回循环列表。
  如何标记这个元素，这题一个是赋值一个很特殊的值，不过总归有漏洞。
  还有就是让节点指向它自己。不过现实中，我们还是在节点中再加一个属性去解决比较好。

  最后其实自己是隐约想到标记这个方法。但是题目不让使用额外的空间，也觉得该值比较不完美，就没往下想。

  如果有多余空间用hashmap 也不错。毕竟有一个containskey方法去快速检查是否已经访问过这个节点。
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
        ListNode index = head;
        while(index != null){
            if (index.equals(index.next)) {
                return true;
            }

            ListNode last = index;
            index = index.next;
            last.next = last;
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
