/*
https://leetcode.com/problems/rotate-image/

Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

import java.util.*;

public class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = n,j = 0; i > 0; i = i - 2, j = j + 1){
            for (int k = 0; k < i; k++ ){
                // may rotate twice in corner
                if (i > 1 && k == i - 1){
                    continue;
                }
                int current = j + k;
                int temp = matrix[j][current];
                // System.out.println("i ： " + i + "  k : " + k + " j : " + j + "  temp : " + temp);
                matrix[j][current] = matrix[n - 1 - current][j];
                matrix[n - 1 - current][j] = matrix[n - 1 - j][n - 1 -current];
                matrix[n - 1 - j][n - 1 - current] = matrix[current][n - 1 - j];
                matrix[current][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] test = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println(s.nums2String(test));
        s.rotate(test);
        System.out.println(s.nums2String(test));
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
