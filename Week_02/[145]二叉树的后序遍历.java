//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 475 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> arr = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        //递归
//        if(root == null) return arr;
//        postorderTraversal(root.left);
//        postorderTraversal(root.right);
//        arr.add(root.val);
//        return arr;
        //迭代
        LinkedList<Integer> link = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root !=null)  stack.addLast(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.removeLast();
            link.addFirst(node.val);
            if (node.left!=null) stack.addLast(node.left);
            if(node.right!=null) stack.addLast(node.right);
        }
        return link;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
