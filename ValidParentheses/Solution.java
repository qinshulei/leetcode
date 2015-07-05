/*
https://leetcode.com/problems/valid-parentheses/

Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/

import java.util.*;

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (s.charAt(i) == '[') {
                stack.push('[');
            } else if (s.charAt(i) == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            } else if (s.charAt(i) == '{') {
                stack.push('{');
            } else if (s.charAt(i) == '}') {
                if (stack.empty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.empty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("true : " + s.isValid("()[]{}"));
        System.out.println("false : " + s.isValid("([)]"));
    }
}
