/*
  https://leetcode.com/problems/palindrome-partitioning/

  Given a string s, partition s such that every substring of the partition is a palindrome.

  Return all possible palindrome partitioning of s.

  For example, given s = "aab",
  Return

  [
  ["aa","b"],
  ["a","a","b"]
  ]

*/

import java.util.*;


public class Solution {

    public List<List<String>> partition(String s)
    {
        List<List<String>> resultList = new ArrayList<List<String>>();
        dfs(new ArrayList<String>(), s, resultList);
        return resultList;
    }

    public void dfs(List<String> result, String subString, List<List<String>> resultList)
    {
        for (int j = 1; j <= subString.length(); j++) {
            String temp = subString.substring(0, j);
            if (isPalindrome(temp))
                {
                    result.add(temp);
                    if(j == subString.length())
                        {
                            List<String> newList = new ArrayList<String>();
                            newList.addAll(result);
                            resultList.add(newList);
                        } else{
                        dfs(result, subString.substring(j), resultList);
                    }
                    result.remove(result.size() - 1);
                }
        }
    }

    public boolean isPalindromeArray(List<String> array){
        for (int i = 0; i < array.size(); i ++){
            if (!isPalindrome(array.get(i))){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++){
            if (str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public void print(List<List<String>> result)
    {
        for(int i=0;i<result.size();i++)
            {
                List<String> sub=result.get(i);
                for(int j=0;j<sub.size();j++)
                    {
                        System.out.print(sub.get(j)+" , ");
                    }
                System.out.println();
            }

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.print(solution.partition("cbbbcc"));
    }
}
