/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

int mySqrt(int x) {
    if(x == 0) return 0;
    int l = 0; int r = x; int mid = (l + r) >> 1;
    while(true)
    {
      if(mid == 0){
        mid = 1;
      }
      int xmid = x/mid;
      if (xmid == mid){
        return mid;
      } else if (xmid - mid == 1){
        return mid;
      } else if (xmid - mid == -1){
        return xmid;
      } else if( xmid - mid > 1){
        l = mid;
      } else if ( xmid - mid < -1){
        r = mid;
      }
      mid = (l + r) >> 1;
    }
}


int main(){
  
  printf("%d \n",mySqrt(1)); 
 
  printf("%d \n",mySqrt(3)); 
  
  printf("%d \n",mySqrt(5));
  
  printf("%d \n",mySqrt(7)); 
  
  printf("%d \n",mySqrt(2147483647));
  
  return 0;
}

























