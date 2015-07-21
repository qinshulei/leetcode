/*
https://leetcode.com/problems/zigzag-conversion/

ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

提交了七次才搞定，关键zigzag没理解，原来是z型。结果靠提交的错误信息理解题目的意思。
关键例子写的也不好，来个四行或者五行的就没有歧义了。
*/

import java.util.*;

public class Solution {

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int cols = s.length() / numRows;
        if (s.length() % numRows != 0) {
            cols = cols + 1;
        }
        cols = cols * 2;

        char[][] temp = new char[numRows][cols];
        char holder = temp[0][0];
        int i = 0;

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < numRows; row++) {
                if (i >= s.length()) {
                    break;
                }

                if ( col % 2 == 0 ) {
                    temp[row][col] = s.charAt(i);
                    i++;
                } else if ( row != 0 && row != (numRows - 1) ){
                    temp[numRows - 1 - row][col] = s.charAt(i);
                    i++;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < cols; col++) {
                if (temp[row][col] != holder){
                    builder.append(temp[row][col]);
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("PAHNAPLSIIGYIR : " + s.convert("PAYPALISHIRING", 3));

        System.out.println("ABCED : " + s.convert("ABCDE", 4));
        System.out.println("ACB : " + s.convert("ABC", 2));
        System.out.println("ABDC : " + s.convert("ABCD", 3));
        System.out.println("ACBD : " + s.convert("ABCD", 2));
        System.out.println("ABFCED : " + s.convert("ABCDEF", 4));
    }
}
