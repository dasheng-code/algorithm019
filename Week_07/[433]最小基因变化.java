//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// 👍 61 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String start, String end, String[] bank) {

//        dfs(start,end,new HashSet<>(),bank,0);
//        return  minCount == Integer.MAX_VALUE?-1:minCount;
        char[] cbank = new char[]{'A','C','G','T'};
        Set<String> bankSet = new HashSet<>();
        for(String s : bank) bankSet.add(s);
        if(!bankSet.contains(end)) return -1;
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> flag = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        int len = 0;
        while(!startSet.isEmpty()&&!end.isEmpty()){
            if(startSet.size() > endSet.size()){
                Set<String> set = startSet;
                startSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for(String s : startSet){
                char[] sc = s.toCharArray();
                for(int i=0;i<sc.length;i++){
                    char old = sc[i];
                    for(char cb : cbank){
                        sc[i] = cb;
                        String next = new String(sc);
                        if(endSet.contains(next)) return len+1;
                        if(bankSet.contains(next) && !flag.contains(next)){
                            temp.add(next);
                            flag.add(next);
                        }
                    }
                    sc[i] = old;
                }
            }
            startSet = temp;
            len++;
        }
        return -1;


    }
    int minCount = Integer.MAX_VALUE;
    public void dfs(String start,String end,Set<String> set,String[] bank,int count){
        if(start.equals(end)){
            minCount = Math.min(count,minCount);
            return;
        }

        for(String s : bank){
            int diff = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) != start.charAt(i)) diff++;
                if(diff>1) break;
            }

            if(diff==1&&!set.contains(s)){
                set.add(s);
                dfs(s,end,set,bank,count+1);
                set.remove(s);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
