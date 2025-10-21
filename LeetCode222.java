class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) { val = x; }

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

public class LeetCode222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int sum = 1 + countNodes(root.left) + countNodes(root.right);
        return sum;
    }
}
