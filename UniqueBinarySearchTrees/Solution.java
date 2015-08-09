/*
Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

import java.util.*;

public class Solution {

    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] save = new int[n + 1];
        save[0] = 1;
        save[1] = 1;

        for (int i = 2; i <= n; i ++) {
            int sum = 0;
            for (int j = 2; j < i; j ++){
                sum += save[j - 1] * save[i - j];
            }
            sum += save[i - 1] * 2;
            save[i] = sum;
        }

        return save[n];
    }


    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(" 5 : " + s.numTrees(3));

    }
}
