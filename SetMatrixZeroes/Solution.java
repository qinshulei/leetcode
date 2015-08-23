/*
https://leetcode.com/problems/set-matrix-zeroes/

Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

import java.util.*;

public class Solution {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                    continue ;
                }
            }
        }

        for (int i = 0; i < rows.length; i ++) {
            if (rows[i]) {
                for (int j = 0; j < matrix[0].length; j ++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < cols.length; i ++) {
            if (cols[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] test = {
            {1,0,1,0},
            {1,0,1,0},
            {1,0,1,0},
            {1,0,1,0}
        };

        s.setZeroes(test);

        for (int i = 0; i < test.length; i ++) {
            for (int j = 0; j < test[0].length; j++) {
                System.out.print(" " + test[i][j]);
            }
            System.out.println("");
        }
    }
}
