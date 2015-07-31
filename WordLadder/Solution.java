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
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        wordDict.add(beginWord);
        wordDict.add(endWord);

        HashMap<String,Set<String>> save = new HashMap<String,Set<String>>();
        for (String start : wordDict) {
            for (String end : wordDict ) {
                if ( !start.equals(end) ){
                    if (isValid(start, end)) {
                        Set<String> tempSet = save.get(start);
                        if (tempSet == null) {
                            tempSet = new HashSet<String>();
                            save.put(start,tempSet);
                        }
                        tempSet.add(end);
                    }
                }
            }
        }

        LinkedList<String> queue = new LinkedList<String>();
        queue.add(beginWord);

        int step = 0;
        while (!queue.isEmpty()) {
            LinkedList<String> level = new LinkedList<String>();
            step++;
            while (!queue.isEmpty()) {
                String q = queue.poll();
                if(q.equals(endWord)){
                    return step;
                }

                Set<String> tempSet = save.get(q);
                if (tempSet == null) {
                    continue;
                }
                wordDict.remove(q);
                for (String key : tempSet) {
                    if (wordDict.contains(key)) {
                        level.add(key);
                        wordDict.remove(key);
                    }
                }
            }
            queue = level;
        }

        return 0;
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
        Solution s = new Solution();
        Set<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        String start = "hit";
        String end = "cog";
        System.out.println("its length = " + s.ladderLength(start, end, set));

        String start2 = "qa";
        String end2 = "sq";
        Set<String> set2 = new HashSet<String>();
        String[] tests = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        for (int i = 0; i < tests.length; i++) {
            set2.add(tests[i]);
        }

        System.out.println("my : its length = " + s.ladderLength(start2, end2, set2));
    }
}
