/*
Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

*/

import java.util.*;

public class Solution {

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            char next = '*';
            if (i + 1 < s.length()){
                next = s.charAt(i + 1);
            }
            if (current == 'M') {
                sum = sum + 1000;
            } else if (current == 'D') {
                sum = sum + 500;
            } else if (current == 'C' && (next == 'M' || next == 'D')) {
                sum = sum - 100;
            } else if (current == 'C' && next != 'M' && next != 'D') {
                sum = sum + 100;
            } else if (current == 'L') {
                sum = sum + 50;
            } else if (current == 'X' && (next == 'C' || next == 'L')) {
                sum = sum - 10;
            } else if (current == 'X' && next != 'C' && next != 'L') {
                sum = sum + 10;
            } else if (current == 'V') {
                sum = sum + 5;
            } else if (current == 'I' && (next == 'X' || next == 'V')) {
                sum = sum - 1;
            } else if (current == 'I' && next != 'X' && next != 'V') {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println( "621 : " + s.romanToInt("DCXXI"));
    }
}
