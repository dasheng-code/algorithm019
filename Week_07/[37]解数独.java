//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 718 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
        for(int i=0 ;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    int n = board[i][j] - '0';
                    row[i][n] = true;
                    col[j][n] = true;
                    box[(i/3)*3+(j/3)][n] = true;
                }
            }
        }
        dfs(board,0,0,row,col,box);
    }
    public boolean dfs(char[][]board,int i,int j,boolean[][] row,boolean[][] col,boolean[][] box){
        if(j == board[0].length){
            j=0;
            i++;
            if(i==board.length){
                return true;
            }
        }
        if(board[i][j] !='.') return dfs(board,i,j+1,row,col,box);

        for(int num=1;num<=9;num++){
            if(!row[i][num]&&!col[j][num]&&!box[(i/3)*3+(j/3)][num]){
                row[i][num] = true;
                col[j][num] = true;
                box[(i/3)*3+(j/3)][num] = true;
                board[i][j] = (char)(num+'0');
                if(dfs(board,i,j+1,row,col,box)) return true;
                row[i][num] = false;
                col[j][num] = false;
                box[(i/3)*3+(j/3)][num] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
