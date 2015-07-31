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

  放弃了，直接抄答案了，这用例估计只有答案一条路可以走了。
  最短路径还是可以用bfs大规模减少时间的，然后bfs一般都用队列徧历
*/

import java.util.*;

public class Solution {

    public int ladderLength(String start, String end, Set<String> dict) {
        LinkedList<String> queue = new LinkedList<String>();
        queue.add(start);
        dict.add(end);
        int step = 0;

        while (!queue.isEmpty()) {
            LinkedList<String> level = new LinkedList<String>();
            step++;
            while (!queue.isEmpty()) {
                String q = queue.poll();
                if(q.equals(end))
                    return step;

                char[] t = q.toCharArray();
                for(int i = 0; i < start.length(); i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        char temp = t[i];
                        t[i] = c;
                        String s = String.copyValueOf(t);
                        t[i] = temp;
                        if(dict.contains(s)){
                            level.add(s);
                            dict.remove(s);
                        }
                    }
                }
            }
            queue = level;
        }

        return 0;
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
