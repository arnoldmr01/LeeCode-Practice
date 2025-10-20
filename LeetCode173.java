import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { this.val = x; }

    public TreeNode() {
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        PushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        PushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void PushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}
