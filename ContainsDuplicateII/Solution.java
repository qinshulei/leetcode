/*

https://leetcode.com/problems/contains-duplicate-ii/

Contains Duplicate II

Given an array of integers and an integer k,
find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j]
and the difference between i and j is at most k.

忘记k==0的情况，特殊情况考虑不全，没有考虑k为负数和0的情况。
*/

import java.util.*;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        LinkedHashSet set = new LinkedHashSet(k, 0.75f);

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            if (set.size() == k) {
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("true : " + s.containsNearbyDuplicate(new int[]{1,2,3,4,5,6,6,7,8}, 1));
        System.out.println("false : " + s.containsNearbyDuplicate(new int[]{1,2,3,4,5,6,7,8}, 1));
        System.out.println("false : " + s.containsNearbyDuplicate(new int[]{1,2,1}, 0));
    }
}
