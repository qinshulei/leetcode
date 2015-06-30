/*
https://leetcode.com/problems/excel-sheet-column-number/

Excel Sheet Column Number

Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28

*/

import java.util.*;

public class Solution {

    public int titleToNumber(String s) {
        char x = 'A' - 1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - x;
            sum = sum * 26 + value;
        }

        return sum;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(" 26 : " + s.titleToNumber("Z"));
        System.out.println(" 27 : " + s.titleToNumber("AA"));
        System.out.println(" 28 : " + s.titleToNumber("AB"));
    }
}
