/*
  https://leetcode.com/problems/rotate-array/

  Rotate Array

  Rotate an array of n elements to the right by k steps.

  For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

  Note:
  Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

*/

import java.util.*;

public class Solution {

    public void rotate(int[] nums, int k) {
        // 确实没想到居然可以大余数组
        k = k % nums.length;

        // 拷贝来，拷贝去，太慢，简单处理一下特殊情况
        if (k == 0 || nums.length == k){
            return;
        }

        int[] temp = new int[k];
        for (int i = 0; i < k; i ++ ) {
            temp[i] = nums[i + nums.length - k];
        }
        for (int i = 0; i < nums.length - k; i ++) {
            nums[nums.length - 1 - i] = nums[nums.length - k - 1 - i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args){
        //  For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
        Solution s = new Solution();
        int[] array = new int[]{1,2,3,4,5,6,7};
        s.rotate(array, 3);
        System.out.println(" [5,6,7,1,2,3,4] : " + s.nums2String(array));

        int[] array2 = new int[]{-1};
        s.rotate(array2, 2);
        System.out.println(" [-1] :" + s.nums2String(array2));

    }

    private String nums2String(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++){
            builder.append(nums[i] + " ");
        }

        return builder.toString();
    }
}
