package Tree;

import java.util.*;

public class Lc46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findPermutation(nums, res, new ArrayList<>());
        return res;
    }

    private void findPermutation(int[] nums, List<List<Integer>> res, List<Integer> ret) {
        if (nums.length == 0) {
            res.add(new ArrayList<>(ret));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            ret.add(nums[i]);
            // create new nums
            int[] newNums = new int[nums.length - 1];
            for (int j = 0, k = 0; j < nums.length; j++) {
                if (j == i) continue;
                newNums[k++] = nums[j];
            }
            findPermutation(newNums, res, ret);
            ret.remove(ret.size() - 1);
        }
    }
}
