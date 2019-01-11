package Tree;

public class Lc230 {
    public int count = 0;
    public int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        count--;
        if (count == 0) {
            res = node.val;
        }
        inOrder(node.right);
    }
}
