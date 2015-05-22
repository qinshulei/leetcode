/*
  Generate Parentheses Total Accepted: 44831 Total Submissions: 138060 My Submissions Question Solution
  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

  For example, given n = 3, a solution set is:

  "((()))", "(()())", "(())()", "()(())", "()()()"

*/
import java.util.*;

public class Solution {
    public static class Parenthes {
        public List<Parenthes> inner = new ArrayList<Parenthes>();
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append("(");
            for (int i = 0; i < inner.size(); i++){
                builder.append(inner.get(i).toString());
            }
            builder.append(")");
            return builder.toString();
        }
    }

    public List<String> generateParenthesis(int n) {
        Parenthes parent = new Parenthes();
        Set<String> ret = new TreeSet<String>();
        List<Parenthes> save = new ArrayList<Parenthes>();
        save.add(parent);
        solve(parent,n,save,ret);
        List<String> result = new ArrayList<String>(ret);
        return result;
    }

    public void solve(Parenthes p, int n,List<Parenthes> save,Set<String> ret){
        if (n == 0){
            String s = p.toString();
            ret.add(s.substring(1,s.length()-1));
            return;
        }

        for (int i = save.size() - 1; i >= 0;i--){
            Parenthes node = save.get(i);
            Parenthes item = new Parenthes();
            node.inner.add(item);
            save.add(item);
            solve(p,n - 1,save,ret);
            node.inner.remove(item);
            save.remove(item);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ret = s.generateParenthesis(3);
        for(int i = 0; i < ret.size(); i++){
            System.out.println(ret.get(i));
        }
    }
}
