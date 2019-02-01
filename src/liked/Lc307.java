package liked;

public class Lc307 {
    private int[] nums;
    private int[] tree;
    private int len;

    public Lc307(int[] nums) {
        len = nums.length;
        this.nums = new int[len];
        tree = new int[len + 1];
        for (int i = 0; i < len; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        if (len == 0) return;

        int diff = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j <= len; j += j & (-j)) {
            tree[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int index) {
        int sum = 0;
        for (int i = index; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
}
