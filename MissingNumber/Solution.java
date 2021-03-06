/*
https://leetcode.com/problems/missing-number/

Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

*/

import java.util.*;

public class Solution {

    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i <= nums.length; i++){
            result ^= i;
        }

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] test = new int[]{3, 1, 0};
        System.out.println(" 2 : " + s.missingNumber(test));
    }
}
