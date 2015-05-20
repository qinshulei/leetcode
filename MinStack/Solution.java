/*
https://leetcode.com/problems/min-stack/

Min Stack Total Accepted: 29916 Total Submissions: 166911 My Submissions Question Solution
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

*/

import java.util.*;

public class Solution {
    class Node{
        public int data;
        public Node next;
        public Node pre;
        public Node(int data, Node pre, Node next){
          this.next = next;
          this.data = data;
          this.pre = pre;
       }
    }
    private Node[] mStackArray = new Node[10];
    private int top;
    private Node head = new Node(0, null, null);
    public void push(int x) {
        Node node = new Node(x, null,null);
        if(mStackArray.length == top + 1)
        {
            Node[] tempArray = new Node[mStackArray.length*2];
            System.arraycopy(tempArray, 0, mStackArray, 0, mStackArray.length);
            mStackArray = tempArray;
        }
        mStackArray[++top] = node;
        if (head.next == null){
            head.next = node;
            head.pre = node;
            node.next = head;
            node.pre = head;
        } else {
            Node cur = head.next;
            while(!cur.equals(head) && cur.next.data <= x)
            {
                cur=cur.next;
            }
            cur.pre.next = node;
            node.next = cur;
            node.pre = cur.pre;
            cur.pre = node;
        }
    }

    public void pop() {
        if (top == 0){
            head.next = null;
            head.pre = null;
            mStackArray[top] = null;
            top = -1;
            return;
        }

        Node node = mStackArray[top];
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        mStackArray[top] = null;
        top = top - 1;
    }

    public int top() {
        return mStackArray[top].data;
    }

    public int getMin() {
        return head.next.data;
    }

    public static void main(String[] args){
        Solution test = new Solution();
        test.push(1);
        test.push(2);
        test.push(3);
        test.pop();
        System.out.println("top :  " + test.top());
        System.out.println("get min  = 1  " + test.getMin());
    }
}
