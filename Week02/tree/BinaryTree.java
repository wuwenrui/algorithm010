/**
 * 二叉树
 *
 *
 */

public class BinaryTree{

    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 二叉树 - 前序遍历，
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
    }

    /**
     * 递归形式
     * 时间复杂度：O(n)
     * 空间复杂度：
     */
    private static void preOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.data);
            preOrder(root.left, res);
            preOrder(root.right, res);
        }
    }


    /**
     * 使用栈的方式
     */
    private static void preOrderStack(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while(curr != null){
                res.add(curr.data);
                stack.push(curr);
                curr = curr.left;
            }
            // 开始出栈、回朔
            curr = stack.pop();
            curr = curr.right;
        }
    }


    /**
     * 中序遍历 -- 递归形式
     */
    private static void inOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrder(root.left, res);
            res.add(root.data);
            inOrder(root.right, res);
        }
    }


    /**
     * 使用栈的方式 - 中序遍历
     */
    private static void inOrderStack(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // 出栈
            curr = stack.pop();
            res.add(curr.data);
            curr = curr.right;
        }
    }


    /**
     * 后序遍历 - 递归方式
     */
    private static void postOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            res.add(root.data);
        }
    }


    /**
     * 后序遍历 -- 使用栈实现
     */


    // --------------------------------------------- 2020/7/2

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> inOrderTree(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }



    // =============================== 中序遍历



    /**
     * 使用递归形式
     */
    private static void inOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrder(root.left, res);
            res.add(root.val);
            inOrder(root.right, res);
        }
    }

    /**
     * 二叉树的中序遍历 - 使用 栈形式
     */
    private static List<Integer> inOrderStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }



    // =========================== 前序遍历

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        pre1(root, res);
        return res;
    }

    /**
     * 使用递归形式
     */
    private static void pre1(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            pre1(root.left, res);
            pre1(root.right, res);
        }
    }


    /**
     * 使用栈形式
     */
    private static void pre2(TreeNode root, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
    }




























}