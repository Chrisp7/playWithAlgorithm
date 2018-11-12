package Array;

/**
 * Created by CP on 11/11/2018.
 */
public class Lc215 {
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            int res = position(nums, l, r);
            if (res + 1 == k)
                return nums[res];
            else if (res + 1 < k)
                l = res + 1;
            else
                r = res - 1;
        }
    }

    public int position(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot)
                swap(nums, l++, r--);
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
