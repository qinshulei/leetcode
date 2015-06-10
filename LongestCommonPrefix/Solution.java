/*
https://leetcode.com/problems/longest-common-prefix/

Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

*/

import java.util.*;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        outer : while (true) {
            if(index >= strs[0].length()){
                break;
            }

            char temp = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++){
                if (index >= strs[i].length()) {
                    break outer;
                } else if (strs[i].charAt(index) != temp){
                    break outer;
                }
            }

            builder.append(temp);
            index++;
        }

        return builder.toString();
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("123 : " +
                           s.longestCommonPrefix(new String[]{"1234567", "1234678", "1233456"}));
        System.out.println(" : " +
                           s.longestCommonPrefix(new String[]{"1234567", "234678", "33456"}));

    }
}
