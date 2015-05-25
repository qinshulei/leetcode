/*
https://leetcode.com/problems/implement-strstr/

Implement strStr() Total Accepted: 51880 Total Submissions: 234330 My Submissions Question Solution
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

*/

import java.util.*;

public class Solution {

    public int strStr(String haystack, String needle) {
        if ("".equals(haystack) && "".equals(needle)){
            return 0;
        }
        outer :
        for (int i = 0; i < haystack.length(); i ++) {
            for (int j = 0; j < needle.length(); j ++) {
                if ( (j == 0 && i + needle.length() - 1 >= haystack.length())
                     || haystack.charAt(i + j) != needle.charAt(j)) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("0 : " + s.strStr("abcde","abc"));
        System.out.println("-1 : " + s.strStr("abcde","abcdefg"));
        System.out.println("2 : " + s.strStr("abcde","cde"));
        System.out.println("-1 : " + s.strStr("abcde","ghi"));
    }
}
