/*
  https://leetcode.com/problems/count-primes/

  Count Primes

  Description:

  Count the number of prime numbers less than a non-negative number, n.

  这题提示给了很多信息。可惜真正自己写，还是遗漏了很多东西。题目也没看清楚。
*/

import java.util.*;

public class Solution {

    public int countPrimes(int n) {
        int magic = (int) Math.sqrt(Integer.MAX_VALUE);
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                if (i <= magic) {
                    for (int j = i * i; j < n; j = j + i ){
                        primes[j] = false;
                    }
                }

            } else {
                primes[i] = false;;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count ++;
            }
        }

        return count;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("0  : " + s.countPrimes(2));
        System.out.println("30  : " + s.countPrimes(120));
        System.out.println("0  : " + s.countPrimes(0));
        System.out.println("0  : " + s.countPrimes(49979));
        System.out.println("0 : " + s.countPrimes(1500000));
        System.out.println(" max value : " + Math.sqrt(Integer.MAX_VALUE));
    }
}
