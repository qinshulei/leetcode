/*
  https://leetcode.com/problems/implement-queue-using-stacks/

  Implement Queue using Stacks

  Implement the following operations of a queue using stacks.

  push(x) -- Push element x to the back of queue.
  pop() -- Removes the element from in front of queue.
  peek() -- Get the front element.
  empty() -- Return whether the queue is empty.
  Notes:
  You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
  Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
  You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).


  看了一下人家的讨论，果然有更简单的方法。在思考这个问题的时候，我确实有想到用两个stack作为存储，但却没能深入下去。

  https://leetcode.com/discuss/44106/short-o-1-amortized

  如此回过头来想，如果存在最优的方法，必然要实现只移动一次，而不能大范围的平移。于是思维被束缚在一次移动一个元素上。
  最终的讨论中的最优方法依然是一次移动多个元素，但平均下来一个元素却只移动一次。
  在push时不对元素进行整理，而只在pop到需要的元素时才整理，整个方法还是挺trick的。

*/

import java.util.*;

public class Solution {

    private Stack<Integer> stack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while (! stack.empty()) {
            temp.push(stack.pop());
        }

        temp.push(x);

        while(! temp.empty()) {
            stack.push(temp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }


    public static void main(String[] args){
        Solution s = new Solution();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("1 : " + s.peek());

    }
}
