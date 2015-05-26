/*
https://leetcode.com/problems/house-robber/

House Robber Total Accepted: 14690 Total Submissions: 51210 My Submissions Question Solution
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.


*/

import java.util.*;

public class Solution {

    private int[] cache;

    public int rob(int[] nums) {
        cache = new int[nums.length];
        return solve(nums,0);
    }

    public int solve(int[] nums, int cur) {
        if (cur >= nums.length){
            return 0;
        }
        int robCur = nums[cur] + solve(nums, cur + 2);
        int unRobCur = solve(nums, cur + 1);

        int max = Math.max(robCur,unRobCur);
        cache[cur] = max;

        return max;
    }

    public static void main(String[] args){

        int[] test = {1,100,1,100,1,100,1,100,1,100,1,1};
        Solution s = new Solution();
        System.out.println(s.rob(test));

        int[] test2 = {104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143};
        System.out.println(s.rob(test2));
    }
}
