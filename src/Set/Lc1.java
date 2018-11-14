package Set;

import java.util.*;

/**
 * Created by CP on 13/11/2018.
 */
public class Lc1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) == null)
                map.put(nums[i], i);
            else {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
        }
        return res;

    }
}
