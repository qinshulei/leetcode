/*
https://leetcode.com/problems/majority-element/

Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Moore's voting algorithm :
每次都找出一对不同的元素，从数组中删掉，直到数组为空或只有一种元素。 不难证明，如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e。

这个方法真算是技巧性的了。
*/

import java.util.*;

public class Solution {

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map =  new HashMap<Integer,Integer>();
        int half = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            if (map.containsKey(nums[i])) {
                sum = map.get(nums[i]) + 1;

            }
            if (sum > half) {
                return nums[i];
            }
            map.put(nums[i], sum );
        }

        return 0;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("2 : " + s.majorityElement(new int[]{1,2,3,4,2,2,2,2}));
        System.out.println("1 : " + s.majorityElement(new int[]{1}));
    }
}
