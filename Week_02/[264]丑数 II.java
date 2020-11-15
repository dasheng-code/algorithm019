//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 421 👎 0


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        //堆
//        Queue<Long> queue = new PriorityQueue<>();
//        queue.add(1l);
//        for(int i =1;i<n;i++){
//            long tmp = queue.poll();
//            while (!queue.isEmpty()&& queue.peek() == tmp) tmp = queue.poll();
//            queue.add(tmp*2);
//            queue.add(tmp*3);
//            queue.add(tmp*5);
//        }
//        return queue.peek().intValue();
//        TreeSet<Long> queue = new TreeSet<>();
//        queue.add(1l);
//        for(int i =1;i<n;i++){
//            long tmp = queue.poll();
//            queue.add(tmp*2);
//            queue.add(tmp*3);
//            queue.add(tmp*5);
//        }
//        return queue.pollFirst().intValue();
        int[] ugly = new  int[n];
        ugly[0] =1;
        int p2=0,p3=0,p5=0;
        int factor2 =2,factor3= 3,factor5=5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min) factor2 = 2*ugly[++p2];
            if (factor3 == min) factor3 = 3*ugly[++p3];
            if (factor5 == min) factor5 = 5*ugly[++p5];
        }
        return ugly[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
