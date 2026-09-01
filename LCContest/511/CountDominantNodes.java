public class CountDominantNodes {
    int domNodes = 0;

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        if (node.val >= leftMax && node.val >= rightMax)
            domNodes++;

        return Math.max(node.val, Math.max(leftMax, rightMax));
    }

    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return domNodes;
    }
}
