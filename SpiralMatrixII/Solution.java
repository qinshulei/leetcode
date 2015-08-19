/*
https://leetcode.com/problems/spiral-matrix-ii/

Spiral Matrix II

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
nnnGiven n = 3,

You should return the following matrix:
n[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/

import java.util.*;

public class Solution {

    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }

        int[][] result = new int[n][n];
        int num = 1;
        for (int i = n,j = 0; i > 0; i = i - 2, j++) {
            if (i == 1){
                result[j][j] = num;
            } else {
                for (int k = 0; k < i - 1; k ++){
                    result[j][k + j] = num;
                    num++;
                }

                for (int k = 0; k < i - 1; k ++) {
                    result[k + j][n - 1 - j] = num;
                    num++;
                }

                for (int k = 0; k < i - 1; k++) {
                    result[n - 1 -j][n - 1 - j - k] = num;
                    num++;
                }

                for (int k = 0; k < i - 1; k++) {
                    result[n - 1 - j - k][j] = num;
                    num++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.nums2String(s.generateMatrix(0)));
        System.out.println(s.nums2String(s.generateMatrix(1)));
        System.out.println(s.nums2String(s.generateMatrix(3)));
        System.out.println(s.nums2String(s.generateMatrix(4)));
        System.out.println(s.nums2String(s.generateMatrix(5)));
    }

    private String nums2String(int[][] nums) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[0].length; j++){
                builder.append(nums[i][j] + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
