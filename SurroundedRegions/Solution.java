/*
  https://leetcode.com/problems/surrounded-regions/

  Surrounded Regions Total Accepted: 29284 Total Submissions: 200303 My Submissions Question Solution
  Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
  4
  A region is captured by flipping all 'O's into 'X's in that surrounded region.

  For example,
  X X X X
  X O O X
  X X O X
  X O X X
  After running your function, the board should be:

  X X X X
  X X X X
  X X X X
  X O X X

*/

import java.util.*;

public class Solution {
    public void solve(char[][] board) {
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[row].length; col ++) {
                if ( board[row][col] != '.'
                     && ( row == 0 || col == 0 || row == board.length - 1 || col == board[row].length - 1 )
                     && board[row][col] == 'O') {

                    board[row][col] = '.';
                    dfs(board, row, col);
                }
            }
        }

        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[row].length; col ++) {
                if ( board[row][col] == '.' ) {
                    board[row][col] = 'O';
                }else if (board[row][col] == 'O'){
                    board[row][col] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board,int row, int col){

        if ( row - 1 >= 0 && board[row - 1][col] == 'O'){
            board[row - 1][col] = '.';
            dfs(board, row - 1, col);
        }

        if ( col + 1 < board[row].length && board[row][col + 1] == 'O'){
            board[row][col + 1] = '.';
            dfs(board, row, col + 1);
        }

        if ( row + 1 < board.length && board[row + 1][col] == 'O'){
            board[row + 1][col] = '.';
            dfs(board, row + 1, col);
        }

        if ( col - 1 >= 0 && board[row][col - 1] == 'O'){
            board[row][col - 1] = '.';
            dfs(board, row, col - 1);
        }
    }


    public static void  main(String[] args){
        char[][] test = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        Solution s = new Solution();
        s.solve(test);
        System.out.print("");
    }
}
