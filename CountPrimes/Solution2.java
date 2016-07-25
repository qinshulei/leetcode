/*
  https://leetcode.com/problems/count-primes/

  Count Primes

  Description:

  Count the number of prime numbers less than a non-negative number, n.

  这题提示给了很多信息。可惜真正自己写，还是遗漏了很多东西。题目也没看清楚。
*/

import java.util.*;

public class Solution2 {

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int[] save = new int[n*2];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i < n; i++) {
            save[i] = 0;
        }

        int save_index = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) continue;

            for (int j = i; j < n && j > 1; j = j * i) {
                if (j != i) {
                    isPrime[j] = false;
                }

                save[save_index] = j;
                save_index++;

                for (int k = 0; save[k] != i; k++) {
                    int temp = save[k] * j;
                    if (temp < n && temp > 1) {
                        isPrime[temp] = false;
                        save[save_index] = temp;
                        save_index++;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Solution2 s = new Solution2();
        System.out.println("0  : " + s.countPrimes(0));
        System.out.println("1  : " + s.countPrimes(3));
        System.out.println("10  : " + s.countPrimes(31));
        System.out.println("30  : " + s.countPrimes(120));
        System.out.println("5130  : " + s.countPrimes(49979));
        System.out.println("114155 : " + s.countPrimes(1500000));
        long endTime = System.currentTimeMillis();
        System.out.println("Cost time : " + (endTime - startTime));
    }
}
