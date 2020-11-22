//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 765 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



import java.util.HashMap;
import java.util.Map;

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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int m = inorder.length;
        if(n != m) return null;
        for(int i=0;i<m;i++) map.put(inorder[i] ,i);
        return buildTree(preorder,0,n-1,inorder,0,m-1);
    }
    public TreeNode buildTree(int[] preorder,int preLeft,int preRight ,int[] inorder,int inLeft,int inRight) {
        if(preLeft>preRight || inLeft>inRight) return null;
        int rootValue = preorder[preLeft];
        int rootIndex = map.get(rootValue);
        TreeNode node = new TreeNode(rootValue);
        node.left = buildTree(preorder,preLeft+1,preLeft+rootIndex-inLeft,inorder,inLeft,rootIndex-1);
        node.right = buildTree(preorder,preLeft+rootIndex-inLeft+1,preRight,inorder,rootIndex+1,inRight);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
