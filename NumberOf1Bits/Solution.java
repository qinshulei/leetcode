/*
Number of 1 Bits

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

*/

import java.util.*;

public class Solution {

    public int hammingWeight(int n) {
        int sum = 0;
        while (n > 0 || n < 0){
            System.out.println(n);
            if ( (n & 1) == 1){
                sum ++;
            }
            n = n >>> 1;
        }
        return sum;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        //System.out.println("3 : " + s.hammingWeight(11));
        //System.out.println("1 : " + s.hammingWeight(-2147483648));
        //System.out.println("31 : " + s.hammingWeight(2147483647));
        //System.out.println("0 : " + s.hammingWeight(0));
    }
}
