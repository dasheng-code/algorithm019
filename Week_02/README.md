学习笔记</br>
# HashMap
  HashMap是基于Map接口实现的，元素是以key-value方式存储的；</br>
  HashMap将key通过hash函数处理后得到在Entry数组中的位置，然后将key-value存储在数组中，当key发生hash碰撞的时候就使用拉链法将不同key值相同的hash存在同一个Entry数组中，用链表连接；</br>

# 哈希
  将任意长度的二进制值串映射为固定长度的二进制值串，这个映射的规则就是哈希算法，而通过原始数据映射之后得到的二进制值串就是哈希值</br>
### 哈希算法可以用来干什么？
  * 1、安全加密 MD5 SHA DES AES
  * 2、唯一标识
  * 3、数据校验 由唯一标识引申的，例如字符串的的异位词，通过判断两个字符串字母的hash值来确定这两个字符串是否是异位词
  * 4、散列函数 key -value
  * 5、数据分片
  * 6、负载均衡
  * 7、分部署存储 一致性hash，hash环

# 树
  典型的应用就是二叉树 由两个特殊的二叉树是 满二叉树和完全二叉树</br></br></br>
  满二叉树：除了叶子节点之外，每个节点都有左右两个子节点</br></br>
  完全二叉树：最后一层的叶子节点都靠左排列，并且除了最后一层，其他层的节点个数都要达到最大</br>
#### 为什么会有完全二叉树的定义？
  二叉树的实现可以是链表可以是数组</br>
  在数组中节点 X 存储在数组中下标为 i 的位置，下标为 2 * i 的位置存储的就是左子节点，下标为 2 * i + 1 的位置存储的就是右子节点</br>
  如果一个二叉树不是完全二叉树那么用数组来实现的二叉树就会浪费空间</br>

### 二叉树的遍历
  * 先序遍历：中左右
  * 中序遍历：左中右
  * 后序遍历：左右中</br>
  用递归或者迭代法（用栈来实现）实现遍历
  * 层序遍历：用队列来实现遍历

### 二叉搜索树
  在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值</br>
  二叉搜索树的中序遍历就是有序的	</br>

# 堆
  可以在一堆树中找到最大或最小的数据结构</br>
  优先队列和topK问题一般都用堆来解决</br>
  ###### 求中位数，就是维护两个堆，一个大顶堆，一个小顶堆</br>


# 图（ps :面试很少问）
  图有边 可以代表权重，每条边可以有方向（单向或双向）</br>
### 微信和微博的社交关系就是两种图，微博是有向图（我关注你才能看到信息，你可以关注我） 微信是无向图（两个人加好友就能互相看到）
  两种存储方法  邻接矩阵存储和邻接表存储</br>


