package liked;

import java.util.*;

public class Lc159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int len = s.length();
        int res = 0;

        while (r < len) {
            if (map.size() <= 2) {
                map.put(s.charAt(r), r);
                r++;
            }
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int num : map.values()) {
                    leftMost = Math.min(leftMost, num);
                }
                map.remove(s.charAt(leftMost));
                l = leftMost + 1;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
