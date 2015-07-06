/*
https://leetcode.com/problems/power-of-two/

Power of Two

Given an integer, write a function to determine if it is a power of two.

*/

import java.util.*;

public class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1){
            if ((n & 1) != 0) {
                return false;
            }
            n = n >> 1;
        }
        if (n != 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("true : " + s.isPowerOfTwo(64));
        System.out.println("false : " + s.isPowerOfTwo(65));
    }
}
