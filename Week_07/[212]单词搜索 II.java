//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 299 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
//leetcode submit region end(Prohibit modification and deletion)
