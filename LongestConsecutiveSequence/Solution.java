/*
https://leetcode.com/problems/longest-consecutive-sequence/

Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

import java.util.*;

public class Solution {

    public int longestConsecutive(int[] nums) {
        BitSet positives = new BitSet(Integer.MAX_VALUE);
        BitSet negatives = new BitSet(Integer.MAX_VALUE);
        boolean haveZero = false;
        boolean haveMin = false;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                positives.set(nums[i] - 1, true);
            }else if (nums[i] == 0){
                haveZero = true;
            } else if (nums[i] == Integer.MIN_VALUE){
                haveMin = true;
            } else {
                negatives.set((-nums[i]) - 1, true);
            }
        }

        int max = 0;
        int startP = 1;
        int startN = 1;
        int endP = Integer.MAX_VALUE;
        int endN = Integer.MAX_VALUE;
        if (haveZero) {
            int sum = 1;
            while (startP <= endP && positives.get(startP - 1)) {
                startP ++;
                sum ++;
            }
            while (startN <= endN && negatives.get(startN - 1)) {
                startN ++;
                sum ++;
            }
            if (sum > max){
                max = sum;
            }
        }

        if (haveMin){
            int sum = 1;
            while(endN >= startN && negatives.get(endN - 1)){
                endN --;
                sum ++;
            }
            if (sum > max) {
                max = sum;
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0
                && ( nums[i] == 1 || (nums[i] >= startP && nums[i] <= endP && ! positives.get(nums[i] - 2)) )){
                int index = startP;
                int sum = 0;
                while (index <= endP && positives.get(index - 1)) {
                    index ++;
                    sum ++;
                }
                if (sum > max) {
                    max = sum;
                }
            } else if( nums[i] < 0
                       && (nums[i] == -1 || (nums[i] >= startN && nums[i] <= endN && ! negatives.get(nums[i] - 2))) ){
                int index = startN;
                int sum = 0;
                while (index <= endN && negatives.get(index - 1)) {
                    index ++;
                    sum ++;
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(s.longestConsecutive(new int[]{0}));
    }
}
