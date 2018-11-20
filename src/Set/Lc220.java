package Set;

import java.util.*;

/**
 * Created by CP on 19/11/2018.
 */
public class Lc220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil=set.ceiling((long)nums[i]-t);
            if (ceil!=null && ceil <= (long)nums[i] + t)
                return true;
            else set.add((long) nums[i]);

            if (set.size() == k + 1) set.remove((long) nums[i - k]);
        }
        return false;
    }


}
