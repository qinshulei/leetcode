/*
  https://leetcode.com/problems/reverse-integer/

  Reverse Integer

  Reverse digits of an integer.

  Example1: x = 123, return 321
  Example2: x = -123, return -321

  click to show spoilers.

  Have you thought about this?
  Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

  If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

  Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

  For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

  Update (2014-11-10):
  Test cases had been added to test the overflow behavior.

*/

import java.util.*;

public class Solution {

    public int reverse(int x) {
        int sum = 0;
        boolean isNegative = false;
        if (x == 1<<31){
            return 0;
        } else if ( x < 0) {
            isNegative = true;
            x = -x;
        }

        while(x > 0) {
            if(x > 0 && sum >= 214748365) {
                return 0;
            }
            sum = sum * 10 + x % 10;
            x = x / 10;
        }
        return isNegative ? -sum : sum;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("321 : " + s.reverse(123));
        System.out.println("-321 : " + s.reverse(-123));
        System.out.println("1 : " + s.reverse(1000));
        System.out.println("0 : " + s.reverse(1000000003));
    }
}
