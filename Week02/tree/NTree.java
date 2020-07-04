/**
 * N 叉树
 */
public class NTree{

    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private static class Node {
        public int val;
        public List<Node> children;
        public Node(){}

        public Node(int val){
            this.val = val;
        }
        public Node(int val, List<Node> children){
            this.val = val;
            this.children = children;
        }
    }


    /**
     * 使用递归实现
     */
    private static void postOrder(Node root, List<Integer> res) {
        if (root != null) {
            for (int i = 0; i < root.children.size(); i++) {
                postOrder(root.children.get(i), res);
            }
            res.add(root.val);
        }
    }

    /**
     * 使用栈实现
     */
    private static LinkedList<Integer> postOrderByStack(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (node tmp : node.children) {
                if (tmp != null) {
                    stack.add(tmp);
                }
            }
        }
        return output;
    }

    private List<Integer> preOrderStack2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> ouput = new LinkedList<>();
        if (root == null) {
            return ouput;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            ouput.addFirst(node.val);
            // 开始操作孩子节点
            for (Node tmp : node.children) {
                if (tmp != null) {
                    stack.push(tmp);
                }
            }
        }
    }


    /**
     * N茶树的层序遍历
     */
    private List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }
























































}