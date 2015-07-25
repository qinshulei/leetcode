/*
https://leetcode.com/problems/integer-to-roman/

Integer to Roman

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.


基本字符
I     V     X     L     C     D     M
相应的阿拉伯数字表示为
1     5     10    50    100   500   1000


1、相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
3、小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
4、正常使用时，连写的数字重复不得超过三次。（表盘上的四点钟“IIII”例外）
5、在一个数的上面画一条横线，表示这个数扩大1000倍。

*/

import java.util.*;

public class Solution {

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int thousand_num = num / 1000;
        int hundred_num = (num % 1000) / 100;
        int dozen_num = (num % 100) / 10;
        int couple_num = num % 10;


        if (thousand_num > 0) {
            for (int i = 0; i < thousand_num; i ++) {
                builder.append("M");
            }
        }

        builder.append(convert(hundred_num,'M','D','C'));
        builder.append(convert(dozen_num,'C','L','X'));
        builder.append(convert(couple_num,'X','V','I'));

        return builder.toString();
    }

    private String convert(int num, char h, char m, char l) {
        StringBuilder builder = new StringBuilder();
        if (num > 0) {
            if (num == 9) {
                builder.append(l).append(h);
            } else if ( num >= 5) {
                builder.append(m);
                for (int i = 0; i < num - 5; i ++){
                    builder.append(l);
                }
            } else if (num == 4){
                builder.append(l).append(m);
            } else {
                for (int i = 0; i < num; i ++) {
                    builder.append(l);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println( "DCXXI : " + s.intToRoman(621));
        System.out.println( "V : " + s.intToRoman(5));
    }
}
