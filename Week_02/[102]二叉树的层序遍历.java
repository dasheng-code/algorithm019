//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 694 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();
        if (root!=null) queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0;i<len;i++){
                TreeNode node = queue.poll();
                if (node.left !=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                cur.add(node.val);
            }
            arr.add(cur);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
