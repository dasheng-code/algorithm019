//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 875 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // int ans = 0;
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(grid[i][j] =='1'){
        //             dfs(grid,i,j);
        //             ans++;
        //         }
        //     }
        // }
        // return ans;
        int space = 0;
        int[][] diss = new int[][]{{0,1},{1,0}};
        UnionFind u = new UnionFind(m*n);
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] =='0'){
                    space++;
                }else{
                    for(int[] dis : diss){
                        int x = i + dis[0];
                        int y = j + dis[1];
                        if(x<m && y <n && grid[x][y] == '1'){
                            u.union(x*n+y,i*n+j);
                        }
                    }
                }
            }
        }
        return u.count - space;
    }

    public void dfs(char[][] grid,int i ,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
}
class UnionFind{
    int count ;
    int[] parent;
    public UnionFind(int n){
        count= n;
        parent= new int[n];
        for(int i =0;i<n;i++){
            parent[i] = i;
        }
    }

    public int find(int p){
        while(p!=parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
