/*
https://leetcode.com/problems/word-search/

Word Search Total Accepted: 35811 Total Submissions: 177454 My Submissions Question Solution
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

*/

import java.util.*;

public class Solution {

    private boolean isDone = false;
    public boolean exist(char[][] board, String word) {
        if(word == null || "".equals(word)){
            return true;
        }

        isDone = false;

        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                if (board[row][col] == word.charAt(0)){
                    board[row][col] = '.';
                    if (solve(board,row,col,1,word)){
                        return true;
                    }
                    board[row][col] = word.charAt(0);
                }
            }
        }

        return false;
    }

    private boolean solve(char[][] board, int row, int col, int offset, String word){
        if (word.length() == offset){
            isDone = true;
            return true;
        }

        char c = word.charAt(offset);
        boolean top = false;
        boolean right = false;
        boolean bottom = false;
        boolean left = false;

        if (isDone == false && row - 1 >= 0 && board[row - 1][col] == c){
            board[row - 1][col] = '.';
            top = solve(board, row - 1, col, offset + 1, word);
            board[row - 1][col] = c;
        }

        if (isDone == false && col + 1 < board[row].length && board[row][col + 1] == c){
            board[row][col + 1] = '.';
            right = solve(board, row, col + 1, offset + 1, word);
            board[row][col + 1] = c;
        }

        if (isDone == false && row + 1 < board.length && board[row + 1][col] == c){
            board[row + 1][col] = '.';
            top = solve(board, row + 1, col, offset + 1, word);
            board[row + 1][col] = c;
        }

        if (isDone == false && col - 1 >= 0 && board[row][col - 1] == c){
            board[row][col - 1] = '.';
            top = solve(board, row, col - 1, offset + 1, word);
            board[row][col - 1] = c;
        }

        return top || right || bottom || left;
    }

    public static void main(String[] args){
        char[][] testCase = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        Solution s = new Solution();
        System.out.println("true : " + s.exist(testCase, "ABCCED"));
        System.out.println("true : " + s.exist(testCase, "SEE"));
        System.out.println("false : " + s.exist(testCase, "ABCB"));
    }
}
