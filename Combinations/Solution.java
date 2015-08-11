/*
https://leetcode.com/problems/combinations/

Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

import java.util.*;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        Queue<Integer> queue_num = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            queue.add(list);
            queue_num.add(i);
        }

        while (! queue.isEmpty()) {
            List<Integer> temp_list = queue.poll();
            int temp = queue_num.poll();

            if (temp == n) {
                continue;
            } else {
                List<Integer> new_temp_list = new ArrayList<Integer>(temp_list);
                new_temp_list.add(temp + 1);

                if (new_temp_list.size() == k) {
                    result.add(new_temp_list);
                }

                if ( (n - (temp + 1)) >= (k - temp_list.size()) ) {
                    queue.add(temp_list);
                    queue_num.add(temp + 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<List<Integer>> result = s.combine(4,2);
        for ( List<Integer> list : result ) {
            for ( Integer i : list ) {
                System.out.print(" " + i);
            }
            System.out.println("");
        }
    }
}
