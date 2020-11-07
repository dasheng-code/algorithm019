//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1798 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        //暴力
        // 雨水的面积 = 每根柱子所能接收的雨水的面积之和；
        //每根柱子所能接收的雨水的面积的条件是它的左边柱子 和右边柱子都要有比它高的柱子 形成低洼才能积水
        //O(N^2)
//        int n = height.length;
//        int ans = 0;
//        for(int i = 1;i<n-1;i++){
//            int max_left = 0,max_right = 0;
//            for (int j =i;j>=0;j--){
//                max_left = Math.max(max_left,height[j]);
//            }
//            for (int j = i ;j<n;i++){
//                max_right = Math.max(max_right,height[j]);
//            }
//            ans += Math.min(max_left,max_right) - height[i];
//        }
//        return ans;

        //暴力优化 动态规划 O(N)
//        int ans = 0;
//        int n = height.length;
//        if (n == 0 || height == null){
//            return 0;
//        }
//        int[] max_left = new int[n];
//        int[] max_right = new int[n];
//        max_left[0] = height[0];
//        for (int i=1;i<n-1;i++){
//            max_left[i] = Math.max(max_left[i-1],height[i]);
//        }
//        max_right[n-1] = height[n-1];
//        for (int i=n-2;i>0;i--){
//            max_right[i] = Math.max(max_right[i+1],height[i]);
//        }
//        for (int i=1;i<n-1;i++){
//            ans += (Math.min(max_left[i],max_right[i]) - height[i]);
//        }
//        return ans;

        //栈 O（N）
//        int n = height.length;
//        Deque<Integer> stack = new ArrayDeque<>();
//        int ans = 0;
//        for (int i=0;i<n;i++){
//            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]){
//                int top = stack.removeLast();
//                if(stack.isEmpty()) break;
//                int weight = i - stack.peekLast() -1;
//                int water_height = Math.min(height[i],height[stack.peekLast()]) - height[top];
//                ans += water_height * weight;
//            }
//
//            stack.addLast(i);
//        }
//        return ans;
        //双指针
        int ans =0;
        int left = 0,right = height.length-1;
        int max_left = 0 ,max_right = 0;
        while (left<right){
            if (height[left] < height[right]){
                if (height[left] >= max_left){
                    max_left = height[left];
                }else {
                    ans += (max_left - height[left]);
                }
                ++left;
            }else {
                if (height[right] >= max_right){
                    max_right = height[right];
                }else {
                    ans += (max_right - height[right]);
                }
                --right;
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
