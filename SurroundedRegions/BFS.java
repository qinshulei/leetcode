/*
https://leetcode.com/problems/surrounded-regions/

Surrounded Regions Total Accepted: 29284 Total Submissions: 200303 My Submissions Question Solution
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

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

public class BFS {
    class Node
    {
        public int x;
        public int y;
        public Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    private Queue<Node> queue = newLinkedList<Node>();
    private vode bfs(char[][] board,int x,int y)
    {
        while( !queue.empty() )
        {
            Node node = queue.poll();
            if( node.x >=0 && node.x <=          {
                board[r][c] = '#';
                q.push( make_pair( r - 1, c) );
                q.push( make_pair( r + 1, c) );
                q.push( make_pair( r, c - 1) );
                q.push( make_pair( r, c + 1) );
            }
        }
    }
    public void solve(char[][] board) {
        visit = new boolean[board.length][board[0].length];
        temp = new boolean[board.length][board[0].length];

        for (int row = 0; row < borad.length; row ++) {
            for (int col = 0; col < board[row].length; col ++) {
                if ( board[row][col] != '.' && ( row == 0 || col == 0 ) && board[row][col] == 'O') {
                    dfs(board, row, col);
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

    public void xx(char[][] board){
        for (int row = 0; row < borad.length; row ++) {
            for (int col = 0; col < board[row].length; col ++) {
                if ( board[row][col] == '.' ) {

                }
            }
        }
    }

    public static void main(String[] args){

    }
}
