/*
  https://leetcode.com/problems/remove-duplicates-from-sorted-array/

  Remove Duplicates from Sorted Array Total Accepted: 67609 Total Submissions: 216061 My Submissions Question Solution
  Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

  Do not allocate extra space for another array, you must do this in place with constant memory.

  For example,
  Given input array nums = [1,1,2],

  Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

  脑子抽风，写了一堆翔一样的代码，明天在看人家的答案来定正。
*/

import java.util.*;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int record = 0;
        int record_start_i = 0;
        int record_end_i = 0;
        int placeholder_start_i = 0;
        int placeholder_end_i = 0;
        for (int i = 0; i < nums.length; i ++)  {
            if (i == 0){
                record = nums[i];
                record_start_i = i;
                record_end_i = i;
            } else if (i == nums.length - 1) {
                if (record == nums[i]) {
                    record_end_i = i;
                    len -= (record_end_i - record_start_i);
                    if (placeholder_start_i != placeholder_end_i){
                        nums[placeholder_start_i + 1] = record;
                    }
                } else {
                    if (record_end_i != record_start_i){
                        len -= (record_end_i - record_start_i);

                        if (placeholder_start_i != placeholder_end_i){
                            nums[placeholder_start_i + 1] = record;
                            placeholder_start_i ++;
                            placeholder_end_i ++;
                            placeholder_end_i += (record_end_i - record_start_i);
                        } else {
                            placeholder_start_i = record_start_i;
                            placeholder_end_i = record_end_i;
                        }
                    } else {
                        if (placeholder_start_i != placeholder_end_i){
                            nums[placeholder_start_i + 1] = record;
                            placeholder_start_i ++;
                            placeholder_end_i ++;
                        }
                    }

                    if (placeholder_start_i != placeholder_end_i){
                        nums[placeholder_start_i + 1] = nums[i];
                    }
                }
            } else if (record == nums[i]) {
                record_end_i = i;
            }  else {
                if (record_start_i != record_end_i) {
                    len -= (record_end_i - record_start_i);

                    if (placeholder_start_i != placeholder_end_i){
                        nums[placeholder_start_i + 1] = record;
                        placeholder_start_i ++;
                        placeholder_end_i ++;

                        placeholder_end_i += (record_end_i - record_start_i);
                    } else {
                        placeholder_start_i = record_start_i;
                        placeholder_end_i = record_end_i;
                    }

                } else {
                    if (placeholder_start_i != placeholder_end_i){
                        nums[placeholder_start_i + 1] = record;
                        placeholder_start_i ++;
                        placeholder_end_i ++;
                    }
                }
                record = nums[i];
                record_start_i = i;
                record_end_i = i;
            }
        }
        return len;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] test = new int[]{1,1,2,2,3,3,4,4,5,6,6,6,7,7,7,7,8,9,10,10};
        System.out.println("10 : " + s.removeDuplicates(test));
        System.out.println(s.nums2String(test));

        int[] test2 = new int[]{1,2,3};
        System.out.println("3 : " + s.removeDuplicates(test2));
        System.out.println(s.nums2String(test2));

        int[] test3 = new int[]{1,1,3};
        System.out.println("2 : " + s.removeDuplicates(test3));
        System.out.println(s.nums2String(test3));

        int[] test4 = new int[]{1,1,2,2};
        System.out.println("2 : " + s.removeDuplicates(test4));
        System.out.println(s.nums2String(test4));

        int[] test5 = new int[]{1,1,2,3};
        System.out.println("3 : " + s.removeDuplicates(test5));
        System.out.println(s.nums2String(test5));

    }

    private String nums2String(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++){
            builder.append(nums[i] + " ");
        }

        return builder.toString();
    }
}
