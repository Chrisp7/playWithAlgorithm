package Tree;

public class Lc404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int res = 0;

        if (isLeaves(root.left))
            res += root.left.val;
        else
            res += sumOfLeftLeaves(root.left);

        res += sumOfLeftLeaves(root.right);
        return res;
    }

    private boolean isLeaves(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        return false;
    }
}
