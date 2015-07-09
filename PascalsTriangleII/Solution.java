/*
https://leetcode.com/problems/pascals-triangle-ii/

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

*/

import java.util.*;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        result.add(1);

        for (int i=1; i <= rowIndex; i++){
            for (int j=i-1; j > 0; j--){
                result.set(j, result.get(j - 1) + result.get(j));
            }
            result.add(1);
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<Integer> test = s.getRow(3);
        s.printList(test);
        List<Integer> test2 = s.getRow(4);
        s.printList(test2);

        List<Integer> test3 = s.getRow(5);
        s.printList(test3);
    }

    private void printList(List<Integer> list){
        for (Integer i : list) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }
}
