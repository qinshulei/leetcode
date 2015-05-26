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
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        return solve(nums,0,0);
    }

    public int solve(int[] nums, int cur,int unRobTimes) {
        if (cur >= nums.length){
            return 0;
        }
        if (cache[cur] != -1 ){
            return cache[cur];
        }

        if (unRobTimes >= 2){
            return nums[cur] + solve(nums, cur + 2, 0);
        }

        int robCur = nums[cur] + solve(nums, cur + 2, 0);
        int unRobCur = solve(nums, cur + 1, unRobTimes + 1);

        int max = Math.max(robCur,unRobCur);
        cache[cur] = max;

        return max;
    }

    public static void main(String[] args){

        int[] test = {1,100,1,100,1,100,1,100,1,100,1,1};
        Solution s = new Solution();
        System.out.println(s.rob(test));

        int[] test2 = {104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143};
        int[] test3 = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(s.rob(test2));
    }
}
