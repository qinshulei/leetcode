/*
https://leetcode.com/problems/reverse-bits/

Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

这题的一大问题是，容易受以前的思路的影响。
但是二进制的反转和十进制的反转还是有个关键的差别的。
就是这里的反转是对全部32位进行反转，而以前做的十进制，只对大于0的部分进行反转。
一开始我也错在了这里，把循环条件写成了 n!=0
*/

import java.util.*;

public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0;i < 32; i++) {
            result = (result << 1);
            if ((n & 1) == 1) {
                result = result + 1;
            }

            n = n >>> 1;
        }

        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();

        System.out.println("2147483648 : " + s.reverseBits(1));

        System.out.println("964176192 : " + s.reverseBits(43261596));
    }
}
