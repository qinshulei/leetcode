/*
https://leetcode.com/problems/minimum-path-sum/

Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

*/

import java.util.*;

public class Solution {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int[][] result = new int[grid.length][grid[0].length];
        result[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i ++){
            result[0][i] = result[0][i - 1] + grid[0][i];
        }
        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++) {
                result[row][col] = Math.min(result[row - 1][col], result[row][col - 1]) + grid[row][col];
            }
        }

        return result[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] test = new int[][] {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 5}
        };
        System.out.println("41 : " + s.minPathSum(test));
    }
}
