/*
https://leetcode.com/problems/product-of-array-except-self/

Product of Array Except Self

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

*/

import java.util.*;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = sum;
            sum = sum * nums[i];
            for (int j = 0; j < i; j++) {
                output[j] *= nums[i];
            }
        }

        return output;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(" {24,12,8,6} " + s.nums2String(s.productExceptSelf(new int[]{1,2,3,4})));
    }

    private String nums2String(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++){
            builder.append(nums[i] + " ");
        }

        return builder.toString();
    }
}
