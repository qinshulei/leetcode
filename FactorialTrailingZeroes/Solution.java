/*
https://leetcode.com/problems/factorial-trailing-zeroes/

Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

简单来说就是要统计多少个5,一开始对每个能被五整除的数慢慢检察，果断时间超了。
这题估计写的好的人直接用数学公式了把，推导不出来，我还是徧历吧。
*/

import java.util.*;

public class Solution {

    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }

        int sum = 0;
        int extra = (int) (Math.log(n) / Math.log(5));
        for (int i = 1 ; i <= extra; i ++){
            sum += n / (Math.pow(5,i));
        }

        return sum;
    }


    public int trailingZeroes2(int n) {
        if (n <= 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i <= n; i = i + 5) {
            int temp = i;
            while ( temp > 1 && temp % 5 == 0 ) {
                result ++;
                temp = temp / 5;
            }
        }

        return result;
    }


    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("1 : " + s.trailingZeroes(5));
        System.out.println("2 : " + s.trailingZeroes(10));
        System.out.println("3 : " + s.trailingZeroes(15));
        System.out.println("4 : " + s.trailingZeroes(20));
        System.out.println("6 : " + s.trailingZeroes(25));
        System.out.println("7 : " + s.trailingZeroes(30));
        System.out.println("8 : " + s.trailingZeroes(35));
        System.out.println("12 : " + s.trailingZeroes(50));


        System.out.println(" : " + s.trailingZeroes(1808548329));
    }
}
