/*
https://leetcode.com/problems/summary-ranges/

Summary Ranges

Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

这题的边界条件还是挺麻烦的。然后在循环中对开始和结束两个位置的特殊处理也有一定的启发。
*/

import java.util.*;

public class Solution {

    public List<String> summaryRanges(int[] nums) {
        int start = -1;
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                start = i;
            } else {
                if (nums[i] != nums[i - 1] + 1){
                    if (nums[start] == nums[i - 1]) {
                        result.add(String.valueOf(nums[i - 1]));
                    } else {
                        result.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[i - 1]));
                    }
                    start = i;
                }
            }

            if (i == nums.length - 1) {
                if (nums[start] == nums[i]) {
                    result.add(String.valueOf(nums[i]));
                } else {
                    result.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[i]));
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(" [\"0->2\",\"4->5\",\"7\"] : " + s.array2String(s.summaryRanges(new int[]{0,1,2,4,5,7})) );
        System.out.println(" [\"0->1\"] : " + s.array2String(s.summaryRanges(new int[]{0,1})) );

    }

    private String array2String(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < strs.size(); i++) {
            builder.append("\"").append(strs.get(i)).append("\",");
        }
        builder.append("]");

        return builder.toString();
    }
}
