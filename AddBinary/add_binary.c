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



char* add(char* m_long, char* m_short, int longLen, int shortLen)
{
   char* result = (char *) malloc ( sizeof(char)*(longLen+3) );
   boolean flag = false;
   int i = 0;
   for (i=0; i < shortLen; i++){
      char s = *(m_long + shortLen - i);
      char l = *(m_short + longLen - i);
     
      if ( s == '0' && l == '0'){
         if ( flag == true){
         
           result[longLen + 1 - i] = '1';
           flag = false;
           
         } else {
         
           result[longLen + 1 - i] = '0';
      
        }
        flag = false;
      } else if ( (s == '0' && l == '1') || ( s == '1' && l == '0' ) ){
        if ( flag == true){
          result[longLen + 1 - i] = '0';
          flag = true;
        }
        else{
          result[longLen + 1 - i] = '1';
          flag = false;
        }
        
      
      } else if ( s == '1' && l == '1' ){
        if (flag == true){
        
          result[longLen + 1 - i] = '1';
          flag = true;
        }
        else{
           result[longLen + 1 - i] = '0';
           flag = true;
        }
      
      
      }
   }
   
   for(; i<longLen; i++)
   {
      char l = *(m_long + longlen - i);
      if ( flag == true ){
        if ( l == '1' ) {
        
        
          result[longLen + 1 - i] = '0';
          flag = false;
        
        } else if ( l == '0' ){
        
          result[longLen + 1 - i] = '1';
        
          flag = false;
          
        }
      } else {
      
        result[longLen + 1 - i] = l;
      
      }
   }
   if(flag == true)
   {
     result[0] = 1;
   }
   
    result[longLen + 2] = 0;
   
    
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

void main(){

    char* a ="11";
    char* b ="1";
    printf("%s",addBinary(a,b));

}