package SetAndMap;

import java.util.*;

/**
 * Created by CP on 14/11/2018.
 */
public class Lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            int subSum = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[r] + nums[l] == subSum) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[r] + nums[l] < subSum)
                    l++;
                else
                    r--;
            }
        }
        return res;
    }

    public int[] removeDuplicate(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] != nums[i + 1])
                temp.add(nums[i]);
        temp.add(nums[nums.length - 1]);
        int[] res = new int[temp.size()];
        int j = 0;
        for (Integer i : temp) {
            res[j++] = i;
        }
        return res;
    }

    public int[] removeDuplicate2(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (r + 1 < nums.length) {
            if (nums[r] != nums[r + 1]) {
                temp.add(nums[l]);
                r++;
                l = r;
            } else
                r++;

        }
        temp.add(nums[nums.length - 1]);
        int[] res = new int[temp.size()];
        int j = 0;
        for (Integer i : temp) {
            res[j++] = i;
        }
        return res;

    }
}
