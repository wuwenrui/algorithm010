## HashMap
- 存储的数据结构：存储在数组中，通过hash（key）算法来计算在数组中的位置，即下标，但是可能发生不同的key结果Hash之后得到的值是相同的，也就是要把他们放在同一个位置之上
    - hash 碰撞：
        1. 占用别人的位置
        2. 升维度：在那个位置上拉出一个链表
- 存储形式：key-value形式存储，key是唯一的，value可以是重复的，相同的key的话，会覆盖原先key对应的值


## 二叉树
> 一种逻辑数据结构，在内存中以链表形式存在
> 遍历一般可分为： 前序遍历、中序遍历、后序遍历
##### 前序遍历 (根 - 左 - 右)
```java
class Test{
static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
    this.val = val;
}
}
// 使用递归
private static void preOrder1(TreeNode root){
    if(root != null){
        System.out.println(root.val);
        preOrder1(root.left);
        preOrder1(root.right);
    }
}
// 使用栈
private static void preOrder2(TreeNode root){
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while(root != null || !stack.isEmpty()){
        while(node != null){
            System.out.println(node.val);
            stack.push(node);
            node = node.left;
        }
        // stack ！= empty
        node = stack.pop();
        node = node.right;
    }
}
}
```

##### 中序遍历（左 - 根 - 右）
```java
class Test{

static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
    this.val = val;
}
}

// 递归实现
private static void inOrder1(TreeNode root){
    if(root != null){
        inOrder1(root.left);
        System.out.println(root.val);
        inOrder1(root.right);       
    }
}
// 使用栈实现
private  static void inOrder2(TreeNode root){
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while(node != null || !stack.isEmpty()){
        while(node != null){
            stack.push(node);
            node = node.left();
        }
        // stack is not empty
        node = stack.pop();
        println(node.val);
        node = node.right;
    }
}
}
```

##### 后序遍历 （左 - 右 - 根）
```java
class Test{
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val){
            this.val = val;
        }
    }

    private static void 


}
```

### 二叉搜索树
> 二叉搜索树，也称为二叉排序树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一颗空树或者具有下列xi性质的二叉树
- 左子树上所有节点均小于它的根节点的值
- 右子树上所有节点均大于它的根节点的值
- 以此类推：左右子树也分别为二叉查找树（这就是重复性）

#### 关于二叉搜索树的操作
- 查找：类似于二分查找的方法，每次筛掉一半的节点，时间复杂度为：log2(n)
- 添加：先进行查找，如果没有找到的话，要插入的节点位置，应该就是最后查找的节点位置
- 删除：删除的话，找到右子树中第一个大于它的树（紧邻它，第一个比它大的数）
