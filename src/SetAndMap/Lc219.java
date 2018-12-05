package SetAndMap;

import java.util.*;

/**
 * Created by CP on 18/11/2018.
 */
public class Lc219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);
            if (set.size() == k + 1) set.remove(nums[i - k]);
        }
        return false;
    }
}
