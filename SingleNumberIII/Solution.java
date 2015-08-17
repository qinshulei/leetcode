/*
https://leetcode.com/problems/single-number-iii/

Single Number III

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

这题的技巧实在太精巧了，但其实也是理所必然，要想线性的解决这个问题，必然要对整个数组进行异或，关键是如何利用异或出来的结果，如何找出那两个数。
条件是有限的，在来思考一下异或出来的值的含意。他是标志了两个数相同的部份，以及不同的部份。那么如何利用这个结果了。

这里最关键的灵感，或者是神来之笔，就是利用其中不同的部份，将数组分割，分割成个包含一个一个数的两个部份，在利用异或，就能得到结果。
那么其实分割的方式其实也很技巧，按道理来说要找到其中的一个1.然后根据这个1去分割。

*/

import java.util.*;

public class Solution {

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }

        diff &=  ~(diff - 1);

        int[] result = new int[]{0,0};

        for (int i = 0; i < nums.length; i++) {
            if ( (diff & nums[i]) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();

        System.out.print("3 , 5 :");
        int[] test = new int[]{1, 2, 1, 3, 2, 5};
        int[] result = s.singleNumber(test);
        System.out.println(" " + result[0] + " , " + result[1]);
    }
}
