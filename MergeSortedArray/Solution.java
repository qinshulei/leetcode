/*
https://leetcode.com/problems/merge-sorted-array/

Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

*/

import java.util.*;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= 0; i--){
            if (m == 0 ){
                nums1[i] = nums2[n - 1];
                n--;
            }else if (n == 0){
                nums1[i] = nums1[m - 1];
                m--;
            } else if (nums1[m - 1] < nums2[n - 1]) {
                nums1[i] = nums2[n - 1];
                n--;
            }else {
                nums1[i] = nums1[m - 1];
                m--;
            }
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums1 = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 4, 6, 8};

        s.merge(nums1, 5, nums2, 4);
        System.out.println(" 1 2 3 4 5 6 7 8 9 : " + s.nums2string(nums1));
    }

    private String nums2string(int[] nums){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            builder.append(" " + nums[i]);
        }

        return builder.toString();
    }
}
