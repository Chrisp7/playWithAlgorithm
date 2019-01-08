package Tree;

public class Lc222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = leftDepth(root);
        int right = rightDepth(root);

        if (left == right) return (1 << left) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1;

    }

    private int leftDepth(TreeNode node) {
        int res = 0;
        while (node != null) {
            node = node.left;
            res++;
        }
        return res;
    }

    private int rightDepth(TreeNode node) {
        int res = 0;
        while (node != null) {
            node = node.right;
            res++;
        }
        return res;
    }
}
