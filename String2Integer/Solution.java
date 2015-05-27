
/*
  https://leetcode.com/problems/string-to-integer-atoi/
  String to Integer

  Implement atoi to convert a string to an integer.

  Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

  Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

  Update (2015-02-10):
  The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

*/

public class Solution {
    public int myAtoi(String str) {
        boolean isNegative = false;
        int i = 0;
        for(i = 0;i<str.length();i++) {
            if(str.charAt(i)=='-' || str.charAt(i)=='+') {
                if(str.charAt(i) == '-'){
                    isNegative = true;
                }
                if(i + 1 < str.length() && str.charAt(i + 1)>='0'&&str.charAt(i + 1)<='9') {
                    str = str.substring(i + 1);
                    break;
                } else {
                    return 0;
                }
            } else if (str.charAt(i)>='0'&&str.charAt(i)<='9') {
                str = str.substring(i);
                break;
            }
            else if(str.charAt(i)==' ') {
                continue;
            }
            else {
                return 0;
            }
        }

        long  result = 0L; // if the number is bigger than long
        for(int j=0;j<str.length();j++) {
            if(str.charAt(j)>='0'&&str.charAt(j)<='9') {
                result=result*10+str.charAt(j)-'0';
                if(!isNegative && result >= 2147483647L)
                    return 2147483647;
                if(isNegative && result >= 2147483648L)
                    return -2147483648;
            }
            else {
                if(isNegative) {
                    return (int)(0-result);
                }
                return (int)result;
            }
        }
        if(isNegative) {
            return (int)(0-result);
        }
        return (int)result;
    }
}
