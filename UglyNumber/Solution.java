/*
https://leetcode.com/problems/ugly-number/

Ugly Number

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/

import java.util.*;

public class Solution {

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (num % 5 == 0) {
            num = num / 5;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }

        if (num != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("true : " + s.isUgly(6));
        System.out.println("true : " + s.isUgly(8));
        System.out.println("false : " + s.isUgly(14));
    }
}
