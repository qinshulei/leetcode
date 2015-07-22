/*
https://leetcode.com/problems/find-peak-element/

Find Peak Element

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

*/

import java.util.*;

public class Solution {

    public static class NumsWrap {
        private int[] nums;

        public NumsWrap(int[] nums) {
            this.nums = nums;
        }

        public int size() {
            return nums.length;
        }

        public int get(int i) {
            if (i == nums.length || i == -1) {
                return Integer.MIN_VALUE;
            } else {
                return nums[i];
            }
        }
    }

    public int findPeakElement(int[] nums) {
        NumsWrap wrap = new NumsWrap(nums);
        for (int i = 0; i < wrap.size(); i ++) {
            if ( wrap.get(i) >= wrap.get(i - 1) && wrap.get(i) >= wrap.get(i + 1) ) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("2 : " + s.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println("0 : " + s.findPeakElement(new int[]{-2147483648}));
    }
}
