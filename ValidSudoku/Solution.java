/*
https://leetcode.com/problems/valid-sudoku/

Valid Sudoku Total Accepted: 34848 Total Submissions: 127646 My Submissions Question Solution
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

*/

import java.util.*;

public class Solution {


    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row<board.length; row++) {
           BitSet rowBit = new BitSet(9);
           for(int col = 0; col<board[row].length; col++) {
              int num = 0;
              if(board[row][col]=='.')
              {
                 continue;
              }
              num = board[row][col] - '1';
              if( rowBit.get(num) ){
                  return false;
              }
              rowBit.set(num, true);
           }
        }

         for(int col = 0; col<board.length; col++)
         {
           BitSet colBit = new BitSet(9);
           for(int row = 0; row<board[col].length; row++)
           {
              int num = 0;
              if(board[row][col]=='.')
              {
                 continue;
              }
              num = board[row][col] - '1';
              if( colBit.get(num) ){
                  return false;
              }
              colBit.set(num, true);
           }
        }

         for(int rowOffset = 0; rowOffset < 9; rowOffset+=3)
            for(int colOffset = 0; colOffset < 9; colOffset+=3)
         {
            BitSet colBit = new BitSet(9);
            for(int i=0;i<3;i++)
              for(int j=0;j<3;j++)
            {
              int row = rowOffset+i;
              int col = colOffset+j;
              int num = 0;
              if(board[row][col]=='.')
              {
                 continue;
              }
              num = board[row][col] - '1';
              if( colBit.get(num) ){
                  return false;
              }
              colBit.set(num, true);
            }
         }
         return true;
    }

    public static void main(String[] args){

    }
}
