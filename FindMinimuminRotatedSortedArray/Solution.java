/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

  Find Minimum in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

写的时候又不小心把取中间的index写成了 (end - start) / 2. 写下来提醒自己 应该是 (start + end) / 2.
*/

import java.util.*;

public class Solution {

    public int findMin(int[] nums) {
        if( nums[nums.length - 1] >= nums[0] ){
            return nums[0];
        }

        int start = 0;
        int end = nums.length -1;

        while (end - start > 1) {
            int mid = (end + start) / 2;
            System.out.println(mid);
            if (nums[mid] > nums[start]){
                start = mid;
            } else if (nums[mid] < nums[end]){
                end = mid;
            }
        }

        return nums[start] > nums[end] ? nums[end] : nums[start];
    }

    public static void main(String[] args){
        Solution s = new Solution();

        System.out.println("0 : " + s.findMin(new int[]{4,5,6,7,0,1}));
        System.out.println("0 : " + s.findMin(new int[]{1,4,5,6,7,0}));

    }
}
