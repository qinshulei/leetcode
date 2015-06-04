/*
https://leetcode.com/problems/longest-consecutive-sequence/

Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

这题的关键在与 O(n),意味着只循环一次，那肯定排不了序。我一开始还是想歪了，搞了个bitset，来实现O(n)的排序。但是
这样使用的内存就超了。

只好看大神答案，我靠，怎么就没想到用hashmap呢。hashmap有效的理想情况实现了O(1)查找。之前之所以没往这个方向想。
总是觉得O(n)情况下查找太费时。有了hashmap，然后就是遍历整个数组，没来一个数字，更新最长列的状态。

因此发现这里还是一个递推的过程。以后做任何题目先按递推的方式去考虑，从0到1,从1到n，然后考虑保存哪些数据可以递推下去。
尤其这种O(n)的题目，它必然在每一次循环都要充分利用已有的中间数据。所以关键是如何存和存哪些以前计算出来的中间数据。
*/

import java.util.*;

public class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < nums.length; i ++){
            int current = nums[i];
            if (map.containsKey(current)){
                continue;
            }

            map.put(current, 1);

            int begin = current;
            int end = current;
            if (map.containsKey(begin - 1)){
                begin = current - map.get(begin - 1);
            }

            if (map.containsKey(end + 1)){
                end = current + map.get(end + 1);
            }
            int len = end - begin + 1;
            map.put(begin, len);
            map.put(end, len);

            if (len > max){
                max = len;
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
