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

public class Solution {
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
    private Queue<Node> queue = new LinkedList<Node>();
    private void bfs(char[][] board)
    {
        while( !queue.isEmpty() )
            {
                Node node = queue.poll();
                if(node.x >=0 && node.x <= board.length-1 && node.y>=0 && node.y<=board[0].length-1 && board[node.x][node.y] =='O' )                    {
                    board[node.x][node.y] = '.';
                    queue.add( new Node(node.x+1,node.y) );
                    queue.add( new Node(node.x-1,node.y) );
                    queue.add( new Node(node.x,node.y+1) );
                    queue.add( new Node(node.x,node.y-1) );
                }
            }
    }
    public void solve(char[][] board) {
        if(board.length < 3)
            return;
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[row].length; col ++) {
                if ( ( row == 0 || col == 0 || row == board.length-1 || col == board[row].length-1) && board[row][col] == 'O') {
                    queue.add(new Node(row, col));
                    //  board[row][col] ='.';
                }
            }
        }
        bfs(board);
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[row].length; col ++) {
                if ( board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                else if(board[row][col] == '.'){
                    board[row][col] = 'O';
                }
            }
        }
    }
}
