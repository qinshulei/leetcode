/*
  https://leetcode.com/problems/min-stack/

  Min Stack Total Accepted: 29916 Total Submissions: 166911 My Submissions Question Solution
  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

  push(x) -- Push element x onto stack.
  pop() -- Removes the element on top of the stack.
  top() -- Get the top element.
  getMin() -- Retrieve the minimum element in the stack.

  ***MARK***
  没做出来，之前做的超时。主要问题是，我尝试实现一个保存顺序的stack。但使用链表作为内部存储，
  导致push性能过差，最终结果超时。但下面这位同学使用两个stack保存就很有创意了。
  类似于以前找最小值的程序，如今存了所有最小值的历史，自然使得最小值这一属性和stack默认属性也一样了。

  Min Stack My Submissions Question Solution

  Hints:
Consider space-time tradeoff. How would you keep track of the minimums using extra space?
Make sure to consider duplicate elements.
O(n) runtime, O(n) space – Extra stack:

Use an extra stack to keep track of the current minimum value. During the push operation we choose the new element or the current minimum, whichever that is smaller to push onto the min stack.

O(n) runtime, O(n) space – Minor space optimization:

If a new element is larger than the current minimum, we do not need to push it on to the min stack. When we perform the pop operation, check if the popped element is the same as the current minimum. If it is, pop it off the min stack too.

*/

import java.util.*;

public class Solution {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            if (x == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
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
