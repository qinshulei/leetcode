/*
https://leetcode.com/problems/permutations/

Permutations

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

*/

import java.util.*;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        Queue<Set<Integer>> status = new LinkedList<Set<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[i]);
            queue.add(temp);
            Set<Integer> temp_set = new HashSet<Integer>();
            temp_set.add(i);
            status.add(temp_set);
        }

        while(!queue.isEmpty()) {
            List<Integer> temp = queue.poll();
            Set<Integer> temp_set = status.poll();

            if (temp_set.size() == nums.length) {
                result.add(temp);
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (temp_set.contains(i)) {
                        continue;
                    }

                    List<Integer> current = new ArrayList<Integer>(temp);
                    Set<Integer> current_status = new HashSet<Integer>(temp_set);
                    current.add(nums[i]);
                    current_status.add(i);
                    queue.add(current);
                    status.add(current_status);
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] test = new int[]{1, 2, 3};
        List<List<Integer>> result = s.permute(test);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(" " + i);
            }
            System.out.println("");
        }
    }
}
