//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 110 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> postorder(Node root) {
        //递归
//        if(root == null) return  list;
//        for(Node children : root.children){
//            postorder(children);
//        }
//        list.add(root.val);
        //迭代
        LinkedList<Integer> list = new LinkedList<>();
        Deque<Node> stack = new ArrayDeque<>();
        if(root != null) stack.offerLast(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            list.addFirst(node.val);
            for(Node children: node.children){
                stack.offerLast(children);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
