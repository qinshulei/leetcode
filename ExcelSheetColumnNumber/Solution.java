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
        for (int i = 0; i < s.size(); i++) {
            sum = sum * 26;

        }
    }

    public static void main(String[] args){

    }
}
