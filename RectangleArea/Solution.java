/*
https://leetcode.com/problems/rectangle-area/

Rectangle Area

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.

我去，情况好多，，漏了无数情况
*/

import java.util.*;

public class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //一个在另一个里面
        if ( A >= E && D <= H && C <= G && B >= F ) {
            return (G - E) * (H - F);
        } else if ( E >= A && H <= D && G <= C && F >= B ) {
            return (C - A) * (D - B);
        }
        // 一个边在另一个里面
        else if ( A >= E && C <= G && D <= H && D >= F) {
            return (G - E) * (H - F) + (C - A) * (D - B) - (C - A) * (D - F);
        } else if ( C >= E && C <= G && D <= H && B >= F){
            return (G - E) * (H - F) + (C - A) * (D - B) - (C - E) * (D - B);
        } else if ( A >= E && C <= G && B <= H && B >= F ){
            return (G - E) * (H - F) + (C - A) * (D - B) - (C - A) * (H - B);
        } else if ( A >= E && A <= G && D <= H && B >= F ) {
            return (G - E) * (H - F) + (C - A) * (D - B) - (G - A) * (D - B);
        }

        else if ( E >= A && G <= C && H >= B && H <= D) {
            return (G - E) * (H - F) + (C - A) * (D - B) - (G - E) * (H - B);
        } else if ( G >= A && G <= C && H <= D && F >= B){
            return (G - E) * (H - F) + (C - A) * (D - B) - (H - F) * (G - A);
        } else if ( E >= A && G <= C && F >= B && F <= D ){
            return (G - E) * (H - F) + (C - A) * (D - B) - (G - E) * (D - F);
        } else if ( E >= A && E <= C && H <= D && F >= B ) {
            return (G - E) * (H - F) + (C - A) * (D - B) - (H - F) * (C - E);
        }
        //一个点在另一个里面
        else if ( A >= E && D <= H && A <= G && D >= F) {
            return (G - E) * (H - F) + (C - A) * (D - B) - (G - A) * (D - F);
        } else if ( C >= E && D >= F && C <= G && D <= H){
            return (G - E) * (H - F) + (C - A) * (D - B) - (C - E) * (D - F);
        } else if ( C >= E && B <= H && C <= G && B >= F ){
            return (G - E) * (H - F) + (C - A) * (D - B) - (C - E) * (H - B);
        } else if ( A >= E && B>= F && A <= G && B <= H ) {
            return (G - E) * (H - F) + (C - A) * (D - B) - (G - A) * (H - B);
        }
        // 相互交叉
        else if (A <= E && C >= G && D <= H && B >= F) {
            return (G - E) * (H - F) + (C - A) * (D - B) - (D - B) * (G - E);
        } else if (E <= A && G >= C && H <= D && F >= B) {
            return (G - E) * (H - F) + (C - A) * (D - B) - (C - A) * (H - F);
        }
        // 相互独立
        else {
            return (G - E) * (H - F) + (C - A) * (D - B);
        }
    }



    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("45 : " + s.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println("24 : " + s.computeArea(-2, -2, 2, 2, -3, -3, 3, -1));
        System.out.println("24 : " + s.computeArea(1, -3, 3, 3, -2, -2, 2, 2));
        System.out.println("24 : " + s.computeArea(-3, -3, -1, 3, -2, -2, 2, 2));
        System.out.println("48 : " + s.computeArea(-5, -2, 5, 1, -3, -3, 3, 3));

    }
}
