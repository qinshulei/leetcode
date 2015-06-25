/*
https://leetcode.com/problems/length-of-last-word/

Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5.

*/

import java.util.*;

public class Solution {

    public int lengthOfLastWord(String s) {
        int sum = 0;
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            } else {
                break;
            }
        }

        for (; i >= 0; i--) {
            if ( (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ){
                sum ++;
            } else {
                break;
            }
        }

        return sum;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("5 : " + s.lengthOfLastWord("Hello World"));
    }
}
