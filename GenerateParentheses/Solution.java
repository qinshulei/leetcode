/*
  Generate Parentheses Total Accepted: 44831 Total Submissions: 138060 My Submissions Question Solution
  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

  For example, given n = 3, a solution set is:

  "((()))", "(()())", "(())()", "()(())", "()()()"

*/

public class Solution {
    private List<String> result = new ArrayList<String>();
    private int size = 0;
    public List<String> generateParenthesis(int n) {
        size = n;
        dfs("(", 1, 0);
        return result;
    }
    public void dfs(String s, int left, int right){
        if(left > size || right > size || right > left)
            return;
        if(left==right && left==size){
            result.add(s);
            return;
        }
        dfs(s+"(",left+1, right);
        dfs(s+")",left, right+1);
    }
}
