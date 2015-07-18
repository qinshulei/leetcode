/*
https://leetcode.com/problems/count-and-say/

Count and Say

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

*/

import java.util.*;

public class Solution {


    public String countAndSay(int n) {
        String seq = "1";
        if (n <= 1) {
            return seq;
        }

        for (int i = 1; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            char last = seq.charAt(0);
            int count = 1;
            for (int j = 1; j < seq.length(); j++) {
                if (last != seq.charAt(j)) {
                    builder.append(count).append(last);
                    count = 1;
                    last = seq.charAt(j);
                } else {
                    count ++;
                }
            }
            if (count > 0) {
                builder.append(count).append(last);
            }
            seq = builder.toString();
        }

        return seq;
    }

    public static void main(String[] args){
        Solution s = new Solution();

        System.out.println("1 : " + s.countAndSay(1));
        System.out.println("11 : " + s.countAndSay(2));
        System.out.println("21 : " + s.countAndSay(3));
        System.out.println("1211 : " + s.countAndSay(4));
        System.out.println("111221 : " + s.countAndSay(5));
    }
}
