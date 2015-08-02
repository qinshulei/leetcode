/*
  https://leetcode.com/problems/valid-anagram/

  Valid Anagram

  Given two strings s and t, write a function to determine if t is an anagram of s.

  For example,
  s = "anagram", t = "nagaram", return true.
  s = "rat", t = "car", return false.

  Note:
  You may assume the string contains only lowercase alphabets.


*/

import java.util.*;

public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();
        int[] s_record = new int[26];
        int[] t_record = new int[26];

        for(int i = 0; i < s.length(); i++) {
            s_record[s.charAt(i) - 'a'] += 1;
            t_record[t.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (s_record[i] != t_record[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(" true : " + s.isAnagram("anagram", "nagaram"));
        System.out.println(" false : " + s.isAnagram("rat", "car"));
    }
}
