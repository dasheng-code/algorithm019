学习笔记

广度优先遍历模板（BFS）
--------
    Queue<T> q = new LinkedList<>();
    if(t!=null) q.offer(t);t
    while(!q.isEmpty()){
      int len = q.size();
      while(len-->0){
        ...
      }
    }
    
理解是否可以使用贪心算法
------
    一组数据中，希望选几个数据，在满足限制条件下，期望值最大
    每次选择数据的时候在 在限制范围内选择对期望值贡献最高的数据（局部最优-->全局最优）
    最后举几个例子证明筛选出来的结果是否是最优
    
    
二分查找
----------
    public int binarySearch(int[] array, int target) {
      int left = 0, right = array.length - 1, mid;
      //判断是否 是写 <= 还是写< ? 
      //在做题中发现的 
      //如果left、right是数组下标一般写< mid = left + (right-left+1)/2
      //如果left、right是数值 一般写<= mid = left + (right-left)/2
      while (left <= right) {
          mid = (right - left) / 2 + left;
          if (array[mid] == target) {
              return mid;
          } else if (array[mid] > target) {
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
        return -1;
    }
    
寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
---------------
    该思路与作业中寻找旋转排序数组中的最小值的实现思路一样
    public int findMin(int[] nums) {
       if(nums.length == 1) return nums[0];
       int left = 0;int right =nums.length-1;
       if(nums[right] >= nums[0]) return nums[0];
       while(left<=right){
           int mid = left + (right-left+1)/2;
           //判断中值是否处于无序的地方
            if(nums[mid-1] > nums[mid]){
               return nums[mid];
           }
           if(nums[mid] > nums[mid+1]){
               return nums[mid+1];
           }
          //判断中值左右哪里是无序的 在无序中去寻找
           if(nums[mid] > nums[0]){
               left = mid+1;
           }else{
               right = mid-1;
            }
       }
       return -1;
    }
