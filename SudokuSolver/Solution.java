/*
  https://leetcode.com/problems/sudoku-solver/

  Sudoku Solver Total Accepted: 27239 Total Submissions: 125819 My Submissions Question Solution
  Write a program to solve a Sudoku puzzle by filling the empty cells.

  Empty cells are indicated by the character '.'.

  You may assume that there will be only one unique solution.


  A sudoku puzzle...


  ...and its solution numbers marked in red.

*/

import java.util.*;

public class Solution {
    private boolean isDone = false;

    public void solveSudoku(char[][] board) {
        solve(board, 0 , 0);
    }

    public void solve(char[][] board, int n, int guess){
        int row = n/9;
        int col = n%9;

        if (board[row][col] != '.'){
            if (row == 8 && col == 8){
                isDone = true;
                return;
            }
            solve(board, n+1, guess);
            return;
        }

        char v = (char)('1' + guess);
        if (isValidSudoku(board, n , v)){
            board[row][col] = v;
            if (row == 8 && col == 8){
                isDone = true;
                return;
            }else{
                solve(board, n+1, 0);
            }
            if (!isDone){
                board[row][col] = '.';
            }
        }
        if (guess + 1 > 8){
            return;
        }
        solve(board, n, guess + 1);
    }

    public boolean isValidSudoku(char[][] board, int n ,char num)
    {
        int row = n / 9;
        int col = n % 9;
        for (int i = 0; i < 9; i++)
        {
            if (board[row][i] == num)
                return false;
        }
        for (int i = 0; i < 9; i++)
        {
            if (board[i][col] == num)
                return false;
        }

        int rowOffset = (row / 3) * 3;
        int colOffset = (col / 3) * 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                int cRow = rowOffset + i;
                int cCol = colOffset + j;
                if (board[cRow][cCol] == num)
                    return false;
            }
        return true;
    }
}
