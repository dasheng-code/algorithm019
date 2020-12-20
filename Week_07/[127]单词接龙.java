//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 655 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> wordset = new HashSet<>(wordList);
//        if(wordList.size() == 0) return 0;
//        Queue<String> q = new LinkedList<>();
//        q.offer(beginWord);
//        Set<String> set = new HashSet<>();
//        set.add(beginWord);
//        int count = 0;
//        while(!q.isEmpty()){
//            int len = q.size();
//            while(len -->0){
//                String s = q.poll();
//                if(s.equals(endWord)) return  count+1;
//                char[] sc = s.toCharArray();
//                for(int i =0;i<sc.length;i++){
//                    char old = sc[i];
//                    for(char k = 'a';k<='z';k++){
//                        if(sc[i] == k) continue;
//                        sc[i] = k;
//                        String newSc = new String(sc);
//                        if(!set.contains(newSc) && wordset.contains(newSc)){
//                            set.add(newSc);
//                            q.offer(newSc);
//                        }
//                    }
//                    sc[i] =old;
//                }
//            }
//            count++;
//        }
//        return 0;
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            //双向bfs
            Set<String> wordSet = new HashSet<>(wordList);
            if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
                return 0;
            }
            Set<String> beginSet = new HashSet<>();
            beginSet.add(beginWord);
            Set<String> endSet = new HashSet<>();
            endSet.add(endWord);
            Set<String> flag = new HashSet<>();
            int len =1;
            while(!beginSet.isEmpty() && !endSet.isEmpty()){
                if(beginSet.size() > endSet.size()){
                    Set<String> set = beginSet;
                    beginSet = endSet;
                    endSet = set;
                }
                Set<String> temp = new HashSet<>();
                for(String word : beginSet){

                    char[] sc = word.toCharArray();
                    for(int i=0;i<sc.length;i++){
                        //  char old = sc[i];
                        for(char k ='a';k<='z';k++){
                            char old = sc[i];
                            sc[i] = k;
                            String next = new String(sc);
                            if(endSet.contains(next)) return len+1;
                            if(wordSet.contains(next) &&!flag.contains(next)){
                                flag.add(next);
                                temp.add(next);
                            }
                            sc[i] = old;
                        }

                    }
                }
                beginSet = temp;
                len++;
            }
            return 0;
        }
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
