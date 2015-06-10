/*
https://leetcode.com/problems/sort-colors/

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

*/

import java.util.*;

public class Solution {

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(i > end) {
                break;
            }

            if(nums[i] == 0) {
                nums[i] = nums[start];
                nums[start] = 0;
                start ++;
            } else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end --;
                i --;
            }
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = new int[]{0,1,2,0,1,2,0};
        s.sortColors(nums);
        System.out.println("0 0 0 1 1 2 2 : " + s.nums2str(nums));

        int[] nums2 = new int[]{1,0};
        s.sortColors(nums2);
        System.out.println("0 1 : " + s.nums2str(nums2));
    }

    private String nums2str(int[] nums){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++){
            builder.append(" " + nums[i]);
        }
        return builder.toString();
    }
}
