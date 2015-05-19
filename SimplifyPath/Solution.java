/*
https://leetcode.com/problems/simplify-path/
Simplify Path Total Accepted: 27759 Total Submissions: 138106 My Submissions Question Solution
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

*/

import java.util.*;

public class Solution {

    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < tokens.length; i++){
            String token = tokens[i];

            if (null == token || "".equals(token)) {
                continue;
            } else if (".".equals(token)){
                continue;
            } else if ("..".equals(token)) {
                if (!stack.empty()){
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.empty()){
            builder.insert(0,stack.pop());
            builder.insert(0,"/");
        }

        String result = builder.toString();
        if ("".equals(result)){
            result = "/";
        }

        return result;

    }

    public static void main(String[] args){
        Solution s = new Solution();

        System.out.println("/home : " + s.simplifyPath("/home/"));
        System.out.println("/c : " + s.simplifyPath("/a/./b/../../c/"));
        System.out.println("/  : " + s.simplifyPath("/../"));
        System.out.println("/home/foo : " + s.simplifyPath("/home//foo"));
    }
}
