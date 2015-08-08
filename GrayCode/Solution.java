/*
https://leetcode.com/problems/gray-code/

Gray Code

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

发现规律的题，就是要先多写几个例子，反思自己是怎么想到这些例子的。然后慢慢找出规律，猜想规律，最后总结出公式。

*/

import java.util.*;

public class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        int[] sequence = new int[]{0, 1, 1, 0};
        int sum = (int)Math.pow(2,n);
        for (int i = 0; i < sum; i++) {
            int base = 0;
            for (int j = 0; j < n; j++){
                base = base + (sequence[ (i >> j) % 4] << j);
            }

            result.add(base);
        }
        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.array2String(s.grayCode(2)));
        System.out.println(s.array2String(s.grayCode(4)));
    }

    private String array2String(List<Integer> ints) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < ints.size(); i++) {
            builder.append("\"").append(ints.get(i)).append("\",");
        }
        builder.append("]");

        return builder.toString();
    }
}
