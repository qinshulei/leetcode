/*
https://leetcode.com/problems/plus-one/

Plus One

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

*/

import java.util.*;

public class Solution {

    public int[] plusOne(int[] digits) {
        boolean isCarry = false;
        for (int i = digits.length - 1; i >= 0; i-- ) {
            int sum = digits[i];
            if (i == digits.length - 1) {
                sum += 1;
            }

            if (isCarry) {
                sum += 1;
            }

            if (sum > 9) {
                isCarry = true;
                digits[i] = sum - 10;
            } else {
                isCarry = false;
                digits[i] = sum;
            }
        }

        if (isCarry) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits,0,result,1,digits.length);
            return result;
        } else {
            return digits;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] result = s.plusOne(new int[]{1,2,3,4,5,6,7,8,9});

        for (int i : result) {
            System.out.print(" " +i);
        }
        System.out.println();
    }
}
