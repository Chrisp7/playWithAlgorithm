package Tree;

public class Lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;

        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode left = helper(nums, l, mid - 1);
        TreeNode right = helper(nums, mid + 1, r);
        node.left = left;
        node.right = right;
        return node;
    }
}
