/*

https://leetcode.com/problems/compare-version-numbers/

Compare Version Numbers 

Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

Input:	"1", "0"

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

//   http://devdocs.io/c

void* memcpy( void          *dest, const void          *src, size_t count );
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int compareVersion(char* version1, char* version2) {
  int pos1 = 0, pos2 = 0;
  int endflag1 = 0, endflag2 = 0;
  for(; version1[pos1]!='.' && version1[pos1]!=0; ++pos1) ;
  if(version1[pos1] == 0) endflag1 = 1;
  for(; version2[pos2]!='.' && version2[pos2]!=0; ++pos2) ;
  if(version2[pos2] == 0) endflag2 = 1;
  version1[pos1] = 0;
  version2[pos2] = 0;
  int n1 = 0, n2= 0;
  if(pos1 != 0) n1 = atoi(version1);
  if(pos2 != 0) n2 = atoi(version2);
  printf("n1--->%d \n",n1);
  printf("n2--->%d \n",n2);

  if(n1 > n2) return 1;
  if(n1 < n2) return -1;
  if(n1 == n2)
  {
    if(endflag1==0 && endflag2==0) return compareVersion(version1+pos1+1, version2+pos2+1);
    if(endflag1==0 && endflag2==1) return compareVersion(version1+pos1+1, version2 + pos2);
    if(endflag1==1 && endflag2==0) return compareVersion(version1 + pos1, version2+pos2+1);;
    if(endflag1==1 && endflag2==1) return 0;
  }
}


int main(){

    char a[] = "01";
    char b[] = "1";
    char c[] = "1.2";
    char d[] = "13.37";
    char e[] = "1";
    char f[] = "2";
    char g[] = "1";
    char h[] = "1.1";
    printf("%d \n",compareVersion(a,b));
    printf("%d \n",compareVersion(b,c));
    printf("%d \n",compareVersion(c,d));
    printf("%d \n",compareVersion(c,c));
    printf("%d \n",compareVersion(e,f));
    printf("%d \n",compareVersion(g,h));

    return 0;
}