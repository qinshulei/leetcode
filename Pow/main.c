/*
  https://leetcode.com/problems/powx-n/

  Pow(x, n) Total Accepted: 48867 Total Submissions: 182624 My Submissions Question Solution

  Implement pow(x, n).
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

double myPow(double x, int n) {
  if(0 == n){
    return 1.0;
  }else if (n < 0){
    // myPow(1, -2147483648) ......
    return 1.0 / (x * myPow(x, -(n + 1)));
  }

  if(1 == n){
    return x;
  }
  double half = myPow(x, n / 2);

  if(n % 2 == 0){
    return half * half;
  } else {
    return half * half * x;
  }

}


int main(){
  printf("4 : %f \n", myPow(2,2));
  printf("8 %f \n", myPow(2,3));

  printf("100 : %f \n", myPow(10,2));
  printf("1024 : %f \n", myPow(2,10));
  printf("0.5 : %f \n", myPow(2,-1));
  printf("1 : %f \n", myPow(1, -2147483648));

  return 0;
}
