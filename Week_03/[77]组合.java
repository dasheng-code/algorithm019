//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 438 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combine(n,k,1);
        return res;
    }
    public void combine(int n,int k ,int cur){
        if(temp.size() + (n-cur+1) <k)return;
        if(temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(cur);
        combine(n,k,cur+1);
        temp.remove(temp.size()-1);
        combine(n,k,cur+1);
    }





}
//leetcode submit region end(Prohibit modification and deletion)
