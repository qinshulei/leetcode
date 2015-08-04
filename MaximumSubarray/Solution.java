/*
Maximum Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

这种题目关键是找出递推公式，并能够保存中间结果，递推公式要能适合于迭代，不然只能写递归了，如何实现适合递归的迭代，显然只能有一个变量。
这题就是只迭代end来递推。
*/

import java.util.*;

public class Solution {

    public int maxSubArray(int[] nums) {
        int[] maxs = new int[nums.length];
        int maxIndex = 0;
        maxs[0] = nums[0];

        for (int i = 1; i < nums.length; i ++) {
            int newMax = Math.max(maxs[i-1] + nums[i], nums[i]);
            maxs[i] = newMax;
            if (newMax > maxs[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxs[maxIndex];
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("6 : " + s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5,4}));
    }
}
