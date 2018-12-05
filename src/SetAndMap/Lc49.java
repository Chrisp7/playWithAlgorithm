package SetAndMap;

import java.util.*;

/**
 * Created by CP on 17/11/2018.
 */
public class Lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (Character ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            String s = "";
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0)
                    s += String.valueOf(count[i]) + String.valueOf((char) (i + 'a'));
            }
            if (map.get(s) != null) {
                List l = map.get(s);
                l.add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(s, newList);
            }
        }
        return new ArrayList<>(map.values());
    }
}
