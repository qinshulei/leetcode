/*
https://leetcode.com/problems/add-digits/

Add Digits

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

Hint:

A naive implementation of the above process is trivial. Could you come up with other methods?
What are all the possible results?
How do they occur, periodically or randomly?
You may find this Wikipedia article useful.
https://en.wikipedia.org/wiki/Digital_root

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.


*/

import java.util.*;

public class Solution {

    public int addDigits(int num) {
        return num - 9 * ((num - 1) / 9);
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(" 7 :" + s.addDigits(65536));
        System.out.println(" 2 :" + s.addDigits(38));
    }
}
