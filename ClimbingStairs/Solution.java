/*
https://leetcode.com/problems/climbing-stairs/

Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

*/

import java.util.*;

public class Solution {

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int last_two_result = 1;
        int last_result = 2;
        int current_result = 2;

        for (int i = 3; i <= n; i++) {
            current_result = last_two_result + last_result;
            last_two_result = last_result;
            last_result = current_result;
        }

        return current_result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("3 : " + s.climbStairs(3));
        System.out.println("1134903170 : " + s.climbStairs(44));
    }
}
