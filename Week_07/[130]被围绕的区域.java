//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 435 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        if(n==0) return;
        // for(int i = 0;i<m;i++){
        //     if(board[i][0] == 'O') dfs(board,i,0);
        //     if(board[i][n-1]=='O') dfs(board,i,n-1);
        // }
        // for(int j =1;j<n-1;j++){
        //     if(board[0][j] == 'O') dfs(board,0,j);
        //     if(board[m-1][j] == 'O') dfs(board,m-1,j);
        // }


        // for(int i =0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(board[i][j] == 'O'){
        //             board[i][j] = 'X';
        //         }else if(board[i][j] == '-'){
        //             board[i][j] = 'O';
        //         }
        //     }
        // }
        UnionFind u = new UnionFind(m*n+1);
        int node = m*n;
        for(int i = 0;i<m;i++){
            if(board[i][0] == 'O') u.union(i*n,node);
            if(board[i][n-1]=='O') u.union(i*n+n-1,node);
        }
        for(int j =1;j<n-1;j++){
            if(board[0][j] == 'O') u.union(j,node);
            if(board[m-1][j] == 'O') u.union((m-1)*n+j,node);
        }

        int[][] directions = new int[][]{{0, 1}, {1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        if (newX < m && newY < n && board[newX][newY] == 'O') {
                            u.union(getIndex(i, j, n), getIndex(newX, newY, n));
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    if (!u.isConnected(getIndex(i, j, n), node)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    public void dfs(char[][]board ,int i ,int j){
        if(i<0||j<0||i>=board.length||j>=board[0].length || board[i][j] == 'X' || board[i][j] == '-'){
            return;
        }
        board[i][j] = '-';
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
        dfs(board,i-1,j);
    }
}
class UnionFind {

    private int[] parent;

    public UnionFind(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        parent[xRoot] = yRoot;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
