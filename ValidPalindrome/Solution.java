/*
https://leetcode.com/problems/valid-palindrome/

Valid Palindrome Total Accepted: 52527 Total Submissions: 238095 My Submissions Question Solution
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

*/

import java.util.*;

public class Solution {

    public boolean isPalindrome(String s) {
        if (s.length() == 0){
            return true;
        }

        int l = 0;
        int r = s.length() - 1;

        while (l < r){
            if (! (isAlpha(s.charAt(l)) || isNumeric(s.charAt(l))) ){
                l++;
                continue;
            }
            if (! (isAlpha(s.charAt(r)) || isNumeric(s.charAt(r))) ){
                r--;
                continue;
            }
            if (! isSameAlphanumeric(s.charAt(l), s.charAt(r))){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public boolean isNumeric(char c){
        if ( c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public boolean isAlpha(char c){
        if ( c >= 'a' && c <= 'z') {
            return true;
        }
        if ( c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    public boolean isSameAlphanumeric(char a,char b){
        if (a == b){
            return true;
        }

        if ( isAlpha(a) && isAlpha(b) && (Math.abs(a - b) == Math.abs('a' - 'A')) ){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        Solution s = new Solution();

        System.out.println("true : " + s.isAlpha('a') );
        System.out.println("true : " + s.isAlpha('A') );
        System.out.println("false : " + s.isAlpha(' ') );
        System.out.println("false : " + s.isNumeric(' ') );
        System.out.println("true : " + s.isNumeric('0') );
        System.out.println("true : " + s.isNumeric('5') );
        System.out.println("true : " + s.isNumeric('9') );
        System.out.println("true : " + s.isSameAlphanumeric('9','9') );
        System.out.println("true : " + s.isSameAlphanumeric('a','A') );
        System.out.println("true : " + s.isSameAlphanumeric('A','a') );
        System.out.println("false : " + s.isSameAlphanumeric('z','a') );

        System.out.println("ture : " + s.isPalindrome("A man, a plan, a canal: Panama") );
        System.out.println("false : " + s.isPalindrome("race a car") );
    }
}
