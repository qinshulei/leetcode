/*
https://leetcode.com/problems/remove-element/

Remove Element

Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

*/

import java.util.*;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            if (nums[start] != val) {
                start ++;
            } else {
                nums[start] = nums[end];
                end --;
            }
        }

        return end + 1;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3,4,5,6,6,6,7,8,9,10};
        System.out.println("9 : " + s.removeElement(nums, 6));
    }
}
