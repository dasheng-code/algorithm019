//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 527 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums,used,new ArrayList<>(),res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list,List<List<Integer>> res){
       if(list.size() == nums.length){
           res.add(new ArrayList<>(list));
           return;
       }
       for(int i =0;i<nums.length;i++){
            if(used[i] || (i>0&& nums[i]==nums[i-1] && used[i-1])) continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
