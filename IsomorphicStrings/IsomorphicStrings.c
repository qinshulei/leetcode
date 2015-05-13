e/*

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>


bool isIsomorphic(char* s, char* t) {
  int sl = strlen(s);
  int tl = strlen(t);
  if(sl != tl)
  {
     return 0;
  }
  char maps[128] = {0,};
  char mapt[128] = {0,};
  for(int i=0; i <  sl; i++)
  {
     if(maps[s[i]] == 0)
     {
         maps[s[i]] = t[i];
     }
     else if( maps[s[i]] != t[i] )
     {
         return 0;
     }
     
     if(mapt[t[i]] == 0)
     {
         mapt[t[i]] = s[i];
     }
     else if( mapt[t[i]] != s[i] )
     {
         return 0;
     }
     
  }
  
  return 1;
    
}

int main(){
  
  printf("%d\n",isIsomorphic("ab","ab"));
  printf("%d\n",isIsomorphic("ab","aa"));
  return 0;
}s