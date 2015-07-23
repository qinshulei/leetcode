/*
https://leetcode.com/problems/product-of-array-except-self/

Product of Array Except Self

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
第一次写实在想不出如何复用前面乘法的结果。结果写了O(n^2)的，居然还过了。
看了讨论，我距离他人的实现其实差关键性的一步，那就是每由想到同时计算正序和逆序两个方向的累积值。
题目要求的一遍徧历，因此能做的变化，无非徧历的次序。以及缓存。
*/

import java.util.*;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = left;
            left = left * nums[i];

        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right = right * nums[i];
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
