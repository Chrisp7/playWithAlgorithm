package Tree;

import java.util.*;

public class Lc47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        findPermutation(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void findPermutation(int[] nums, List<List<Integer>> res, List<Integer> ret, boolean[] used) {
        if (ret.size() == nums.length) {
            res.add(new ArrayList<>(ret));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            ret.add(nums[i]);
            findPermutation(nums, res, ret, used);
            used[i] = false;
            ret.remove(ret.size() - 1);
        }
    }

}
