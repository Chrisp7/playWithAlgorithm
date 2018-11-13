package Set;

import java.util.*;

/**
 * Created by CP on 12/11/2018.
 */
public class Lc349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> res = new HashSet<>(nums2.length);
        for (int j : nums2) {
            if (set.contains(j))
                res.add(j);
        }
        int k = 0;
        int[] resArr = new int[res.size()];
        for (Integer i : res)
            resArr[k++] = i;
        return resArr;

    }
}
