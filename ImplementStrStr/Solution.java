/*
https://leetcode.com/problems/implement-strstr/

Implement strStr() Total Accepted: 51880 Total Submissions: 234330 My Submissions Question Solution
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

这题一开始，我并没有想到用 haystack.length()-needle.length() 的方式去保证，下面的匹配不会越界，
反而是直接和以前一样遍历整个haystack.这也说明由于自己习惯了写一个传统的循环，而忘记正在的去思考循环的目的。
这里循环是为了循环可用的起点。因此明显haystack结尾部分可能并不是一个值得遍历的位置。
写for循环时，我们应该充分思考循环的每一个条件，而不是机械的写一个循环模板。
充分思考每一行代码的目的，以及它最该在什么位置出现，可以在什么时候出现，并考虑代码可读性去则中。
就和面向对象中的类方法一样。思考每一个方法是谁的职责，它该在什么位置。
*/

import java.util.*;

public class Solution {

    public int strStr(String haystack, String needle) {
        if ("".equals(haystack) && "".equals(needle)){
            return 0;
        }
        outer : for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            for (int j = 0; j < needle.length(); j ++) {
                if ( haystack.charAt(i + j) != needle.charAt(j)) {
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
