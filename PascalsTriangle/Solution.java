/*
https://leetcode.com/problems/pascals-triangle/

Pascal's Triangle
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/

import java.util.*;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return result;
        }

        List<Integer> dummy = new ArrayList<Integer>();
        dummy.add(1);
        result.add(dummy);

        for (int i=1;i < numRows; i++){
            List<Integer> temp = new ArrayList<Integer>();
            for (int j=0; j <= i; j++){
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<List<Integer>> result = s.generate(5);
        for (List<Integer> list : result){
            for (Integer i : list) {
                System.out.print(" " + i);
            }
            System.out.println("");
        }
    }
}
