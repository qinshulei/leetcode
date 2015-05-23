/*
  https://leetcode.com/problems/palindrome-number/

  Palindrome Number Total Accepted: 57378 Total Submissions: 192893 My Submissions Question Solution
  Determine whether an integer is a palindrome. Do this without extra space.

  click to show spoilers.

  Some hints:
  Could negative integers be palindromes? (ie, -1)

  If you are thinking of converting the integer to string, note the restriction of using extra space.

  You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

  There is a more generic way of solving this problem.
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<math.h>

bool isPalindrome(int x) {
  if (x < 0){
    return false;
  }

  int len = log10(x);
  int mid = len / 2;
  for (int i = 0; i <= mid; i ++) {
    int low_base = pow(10,i);
    int high_base = pow(10,len - i);
    int low = (x / low_base) % 10;
    int high = ( x / high_base ) % 10;
    if (low != high){
      return false;
    }
  }

  return true;
}

int main(){
  printf("%s \n", "Hello world!");

  printf("1 : %d \n",isPalindrome(123321));
  printf("1 : %d \n",isPalindrome(1234321));
  printf("0 : %d \n",isPalindrome(10));
  printf("0 : %d \n",isPalindrome(-2147483648));
  printf("1 : %d \n",isPalindrome(-2147447412));
  return 0;
}
