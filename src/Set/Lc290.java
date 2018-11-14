package Set;

import java.util.*;

/**
 * Created by CP on 13/11/2018.
 */
public class Lc290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        if (pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (map1.get(pattern.charAt(i)) != null) {
                if (!map1.get(pattern.charAt(i)).equals(words[i])) return false;
            }
            else {
                if (!map1.containsValue(words[i]))
                    map1.put(pattern.charAt(i),words[i]);
                else
                    return false;
            }
        }

        return true;
    }

}
