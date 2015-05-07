/**
// https://leetcode.com/problems/add-binary/

// Given two binary strings, return their sum (also a binary string).

// For example,
// a = "11"
// b = "1"
// Return "100".
**/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>


char* add(char* m_long, char* m_short, int longLen, int shortLen)
{
   char* result = (char *) malloc ( sizeof(char)*(longLen+2) );
   
   result[longLen + 1] = 0;
  
   int flag = 0;
   int i = 0;
   for (i=0; i < shortLen; i++){
      char s = *(m_short + shortLen - i - 1);
      char l = *(m_long + longLen - i - 1);
     
      if ( s == '0' && l == '0'){
         if ( flag == 1){
         
           result[longLen - i] = '1';
           flag = 0;
           
         } else {
         
           result[longLen - i] = '0';
      
        }
        flag = 0;
      } else if ( (s == '0' && l == '1') || ( s == '1' && l == '0' ) ){
        if ( flag == 1){
          result[longLen - i] = '0';
          flag = 1;
        }
        else{
          result[longLen - i] = '1';
          flag = 0;
        }
        
      
      } else if ( s == '1' && l == '1' ){
        if (flag == 1){
        
          result[longLen - i] = '1';
          flag = 1;
        }
        else{
           result[longLen - i] = '0';
           flag = 1;
        }
      
      
      }
   }
   
   
   for(; i<longLen; i++)
   {
      char l = *(m_long + longLen - i - 1);
      if ( flag == 1 ){
        if ( l == '1' ) {
        
        
          result[longLen - i] = '0';
          flag = 1;
        
        } else if ( l == '0' ){
        
          result[longLen - i] = '1';
        
          flag = 0;
          
        }
      } else {
      
        result[longLen - i] = l;
      
      }
   }
   
   
   if(flag == 1)
   {
     result[0] = '1';
   } else {
     
     result = result + 1;
   }
   
   return result; 
    
}

char* addBinary(char* a, char* b){
  int lenA=strlen(a);
  int lenB=strlen(b);
  if(lenA>lenB)
  {
     return add(a,b,lenA,lenB);
  }
  else
  {
     return add(b,a,lenB,lenA);
  }
    
}

int main(){
    char* a ="101010010000110110111100101111000111111011001110111001111000";
    char* b ="10001110100001111000001110001000000101011011100001011101101001000000101001111010111001110000";
    printf("%s \n",addBinary(a,b));
    return 0;
}