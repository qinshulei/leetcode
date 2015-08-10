/*
https://leetcode.com/problems/unique-paths/

Unique Paths Total Accepted: 53656 Total Submissions: 162742 My Submissions Question Solution
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

*/

import java.util.*;

public class Solution {

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0){
            return 0;
        }
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i ++){
            map[i][0] = 1;
        }
        for (int i = 0; i < n; i++){
            map[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }

        return map[m-1][n-1];
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("1 : " + s.uniquePaths(1,1));
        System.out.println("2 : " + s.uniquePaths(2,2));
        System.out.println("3 : " + s.uniquePaths(2,3));

    }
}
