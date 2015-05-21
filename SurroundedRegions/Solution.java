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


  一开始使用dfs，结果堆栈溢出。递归就是这个坏处，于是去掉了递归，其实就变成了bfs。
  最佳的写法还是用队列去存点，参考x神的BFS.java
  以后遇到类似问题优先使用bfs去解决。队列的话可以很好的处理状态。
*/

import java.util.*;

public class Solution {

    public static class Point {
        public int x;
        public int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[row].length; col ++) {
                if ( board[row][col] != '.'
                     && ( row == 0 || col == 0 || row == board.length - 1 || col == board[row].length - 1 )
                     && board[row][col] == 'O') {

                    board[row][col] = '.';

                    List<Point> save = new ArrayList<Point>();
                    save.add(new Point(row,col));

                    while(true){
                        if(save.size() == 0){
                            break;
                        }

                        List<Point> temp = new ArrayList<Point>();
                        for (int i = 0;i < save.size(); i++){
                            Point p = save.get(i);
                            int x = p.x;
                            int y = p.y;
                            if ( x - 1 >= 0 && board[x - 1][y] == 'O'){
                                board[x - 1][y] = '.';
                                temp.add(new Point(x - 1, y));
                            }

                            if ( y + 1 < board[x].length && board[x][y + 1] == 'O'){
                                board[x][y + 1] = '.';
                                temp.add(new Point(x, y + 1));
                            }

                            if ( x + 1 < board.length && board[x + 1][y] == 'O'){
                                board[x + 1][y] = '.';
                                temp.add(new Point(x + 1, y));
                            }

                            if ( y - 1 >= 0 && board[x][y - 1] == 'O'){
                                board[x][y - 1] = '.';
                                temp.add(new Point(x, y - 1));
                            }
                        }
                        save = temp;
                    }
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
