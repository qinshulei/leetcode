/*
  https://leetcode.com/problems/search-a-2d-matrix/

  Search a 2D Matrix


  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

  Integers in each row are sorted from left to right.
  The first integer of each row is greater than the last integer of the previous row.
  For example,

  Consider the following matrix:

  [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
  ]
  Given target = 3, return true.


  这题边界搞了很久，首先是在行这个级别搜索时，和普通二分的查找的结束条件有些区别，我们要找到数字可能在的行。
  而普通二分的结束条件会导致我们偏离那一行。
  然后是不小心忘了length - 1，结果绕了一圈才发现。
  最后是大于等于没细想等于的情况，写成了大于。真的是一行都不能大意，一个大意就会导致后面排查的困难。
*/

import java.util.*;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowMin = 0;
        int rowMax = matrix.length - 1;
        while (rowMax - rowMin > 1) {
            int rowMid = (rowMin + rowMax) / 2;
            if (target > matrix[rowMid][0]){
                rowMin = rowMid;
            } else if (target < matrix[rowMid][0]) {
                rowMax = rowMid;
            } else {
                return true;
            }
        }

        int row = rowMin;
        if (target >= matrix[rowMax][0]) {
            row = rowMax;
        }

        int colMin = 0;
        int colMax = matrix[row].length - 1;

        System.out.println("row : " + row);

        while (colMax - colMin >= 0){
            int colMid = (colMin + colMax) / 2;

            if (target > matrix[row][colMid]){
                colMin = colMid + 1;
            } else if (target < matrix[row][colMid]) {
                colMax = colMid - 1;
            } else {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] test = new int[][] {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 5}
        };

        System.out.println("true : " + s.searchMatrix(test, 3));

        int[][] test2 = new int[][] {
            {1}
        };

        System.out.println("false : " + s.searchMatrix(test2,2));


        int[][] test3 = new int[][] {
            {1, 3}
        };

        System.out.println("true : " + s.searchMatrix(test3,1));

        int[][] test3 = new int[][] {
            {1, 3}
        };


        System.out.println("true : " + s.searchMatrix(test3,3));

    }
}
