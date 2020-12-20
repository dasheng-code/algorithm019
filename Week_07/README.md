学习笔记


单词搜索2的时间复杂度
-------------
    递归是指数级的 每次找到一个单词有相邻的3格每次有4格方向 3^(L-1) * 4 L是单词长度
    class Solution {
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    Trie trie = new Trie();
    Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                dfs(board,trie,i,j);
            }
        }
        return new LinkedList<String>(res);
    }


    public void dfs(char[][] board,Trie root,int i ,int j){
        
        if(i<0 || j<0 || i>=board.length || j>= board[0].length  ||  board[i][j] == '.'){
            return;
        }
        root = root.next[board[i][j] -'a'];
        char c = board[i][j];
        board[i][j] = '.';
        if(root == null){
            board[i][j] = c;
            return;
        }
        
        if(root.isEnd){
            res.add(root.word);
        }
        for(int k =0;k<4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(board,root,x,y);
        }
        board[i][j] = c;
    }
}
    class Trie{
          public boolean isEnd;
          public Trie[] next;
          public String word;
          public Trie(){
              isEnd = false;
              next = new Trie[26];
              word = "";
          }

    public void insert(String word){
        if(word == null || word.length() == 0) return ;
        Trie cur = this;
        char[] words = word.toCharArray();
        for(int i=0;i<words.length;i++){
            int n = words[i] - 'a';
            if(cur.next[n] == null){    
                cur.next[n] = new Trie();
            }
            cur = cur.next[n];
        }
        cur.isEnd = true;
        cur.word = word;
    }

    private Trie searchPrefix(String word){
        Trie node = this;
        char[] words = word.toCharArray();
        for(int i =0;i<words.length;i++){
            node = node.next[words[i] - 'a'];
            if(node == null) return null;
        }
        return node;
    }
    public boolean search(String word){
        Trie node = searchPrefix(word);
        return node!=null&&node.isEnd;
    }

     public boolean searchStartWith(String word){
        Trie node = searchPrefix(word);
        return node!=null;
    }

    public boolean containsKey(char c){
        Trie node= this;
        int n = c- 'a';
        if(node.next[n] == null){
            return false;
        }
        return true;
    }
  }
  
  
  
双向BFS模板
-----------------

    //定义首尾两个集合
       Set<String> beginSet = new HashSet<>();
           beginSet.add(beginWord);
           Set<String> endSet = new HashSet<>();
           endSet.add(endWord);
           Set<String> flag = new HashSet<>();
           int len =1;
           while(!beginSet.isEmpty() && !endSet.isEmpty()){
              //从集合数最少的开始遍历
               if(beginSet.size() > endSet.size()){
                   Set<String> set = beginSet;
                   beginSet = endSet;
                   endSet = set;
               }
               Set<String> temp = new HashSet<>();
               for(String word : beginSet){
                    .......
                    //判断首集合的元素在尾集合中就返回结束
                     if(endSet.contains(next)) return len+1;
                }
      }
