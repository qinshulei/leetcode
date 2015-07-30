/*
  https://leetcode.com/problems/word-ladder/

  Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

  Only one letter can be changed at a time
  Each intermediate word must exist in the dictionary
  For example,

  Given:
  start = "hit"
  end = "cog"
  dict = ["hot","dot","dog","lot","log"]
  As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
  return its length 5.

  Note:
  Return 0 if there is no such transformation sequence.
  All words have the same length.
  All words contain only lowercase alphabetic characters.

*/

import java.util.*;

public class Solution {
    private HashMap<String,HashMap<String,Integer>> save = new HashMap<String,HashMap<String,Integer>>();
    private int count = -1;
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        for (String start : wordDict) {
            for (String end : wordDict ) {
                if ( !start.equals(end) ){
                    if (isValid(start, end)) {
                        Map map = save.get(start);
                        if (map == null) {
                            save.put(start,new HashMap<String, Integer>());
                        }
                        map.put(end,1);
                    }
                }
            }
        }

        solve(beginWord, endWord, wordDict,0);

        if (count == -1) {
            return 0;
        }
        return count;
    }

    public void solve(String start,String end,Set<String> dict,int num) {
        if (start == end) {
            if (count == -1 || count > num) {
                count = num;
            }
        }
        map = save.get(start);
        if (map == null) {
            return;
        }

        Set<String> set = new HashSet<String>();
        set.add(dict);
        set.remove(start);
        set.remove(end);

        for (Map.Entry<String,Integer> entry : map) {
            String key = entry.getKey();
            if (set.contains(key)) {
                solve(key,end,set,num + 1);
            }
        }
    }

    public boolean isValid(String start,String end) {
        boolean flag = false;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == end.charAt(i)){
                continue;
            } else if ( flag == false && start.charAt(i) != end.charAt(i)) {
                flag = true;
            } else {
                return false;
            }
        }
        return flag;
    }

    public static void main(String[] args){
        Set<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        String start = "hit";
        String end = "cog";
        System.out.printf("its length = %d", ladderLenth(start, end, set));
    }
}
