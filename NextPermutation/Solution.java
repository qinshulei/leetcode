/*
https://leetcode.com/problems/next-permutation/

Next Permutation Total Accepted: 35741 Total Submissions: 143097 My Submissions Question Solution

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

1,3,2 .. 2 3 1

*/

import java.util.*;

public class Solution {

    public void nextPermutation(int[] nums) {
        int index = findMax(nums);
        if (index != 0){
            doReplace(nums, index - 1);
        }

        doReverse(nums, index);
    }

    private void doReverse(int[] nums, int start) {
        int temp = 0;
        for (int i = 0; i < (nums.length - start)/2; i++) {
            temp = nums[start + i];
            nums[start + i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }

    private void doReplace(int[] nums , int compareIndex) {
        for (int i = nums.length - 1; i > compareIndex; i--) {
            if (nums[i] > nums[compareIndex]){
                int temp = nums[compareIndex];
                nums[compareIndex] = nums[i];
                nums[i] = temp;
                break;
            }
        }
    }

    private int findMax(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        Solution s = new Solution();

        System.out.println("0 : " + s.findMax(new int[]{3,2,1}));
        System.out.println("1 : " + s.findMax(new int[]{2,3,1}));
        System.out.println("2 : " + s.findMax(new int[]{2,1,3}));


        int[] test = new int[]{2,3,1};
        s.doReplace(test, 0);
        System.out.println("3 2 1 : " + s.nums2String(test));


        int[] nums = new int[]{1, 2, 3};
        s.nextPermutation(nums);
        System.out.println("1 3 2 : " + s.nums2String(nums));
        s.nextPermutation(nums);
        System.out.println("2 1 3 : " + s.nums2String(nums));
        s.nextPermutation(nums);
        System.out.println("2 3 1 : " + s.nums2String(nums));
        s.nextPermutation(nums);
        System.out.println("3 1 2 : " + s.nums2String(nums));
        s.nextPermutation(nums);
        System.out.println("3 2 1 : " + s.nums2String(nums));
        s.nextPermutation(nums);
        System.out.println("1 2 3 : " + s.nums2String(nums));

        int[] nums2 = new int[]{1, 1, 5};
        s.nextPermutation(nums2);
        System.out.println("1 5 1 : " + s.nums2String(nums2));
        s.nextPermutation(nums2);
        System.out.println("5 1 1 : " + s.nums2String(nums2));
        s.nextPermutation(nums2);
        System.out.println("1 1 5 : " + s.nums2String(nums2));

    }

    private String nums2String(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++){
            builder.append(nums[i] + " ");
        }

        return builder.toString();
    }
}
