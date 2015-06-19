/*
https://leetcode.com/problems/contains-duplicate/

Contains Duplicate

Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.

本想自己尝试一下实现HashSet，但一下子感觉复杂了很多。

要写一个完全适合这题的容器或许并不困难，但花的时间和用现成的容器的时间相比，肯定就不是一个数量级了。
没错，很多问题一个人有足够时间都能解决。但完美解决并不和收益成正比。能够善用已有的代码已经足够了。
因此深入理解java源码还是很有必要的。每个类产生的原因，为了解决什么问题。值得好好记忆。
*/

import java.util.*;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("true : " + s.containsDuplicate(new int[]{1,2,3,4,5,3}));
    }
}
