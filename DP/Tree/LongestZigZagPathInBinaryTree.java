public class LongestZigZagPathInBinaryTree {
    int maxStep = 0;

    public void dfs(TreeNode node, int dir, int step) // 1 -> left, 2 -> right
    {
        if (node == null)
            return;

        maxStep = Math.max(maxStep, step);

        if (dir == 1) {
            dfs(node.right, 2, step + 1);
            dfs(node.left, 1, 1);
        } else {
            dfs(node.left, 1, step + 1);
            dfs(node.right, 2, 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root.left, 1, 1);
        dfs(root.right, 2, 1);

        return maxStep;
    }
}
