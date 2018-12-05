package SetAndMap;

/**
 * Cr
 * eated by CP on 13/11/2018.
 */

import java.util.*;

public class Lc242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.get(s.charAt(i)) == null) sMap.put(s.charAt(i), 1);
            else sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (sMap.get(t.charAt(i)) == null)
                return false;
            else {
                sMap.put(t.charAt(i), sMap.get(t.charAt(i)) - 1);
                if (sMap.get(t.charAt(i)) == 0)
                    sMap.remove(t.charAt(i));
            }
        }
        return true;
    }
}
