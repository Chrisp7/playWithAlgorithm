package liked;

import java.util.*;

public class Lc269 {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        StringBuilder res = new StringBuilder();
        HashMap<Character, Set<Character>> map = new HashMap<>();

        int[] degree = new int[26];
        int count = 0;

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (degree[ch - 'a'] == 0) {
                    count++;
                    degree[ch - 'a'] = 1;
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                if (cur.charAt(j) != next.charAt(j)) {
                    if (!map.containsKey(cur.charAt(j))) {
                        map.put(cur.charAt(j), new HashSet<>());
                    }
                    if (map.get(cur.charAt(j)).add(next.charAt(j))) {
                        degree[next.charAt(j) - 'a']++;
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 1) {
                queue.offer((char) (i + 'a'));
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);
            if (map.containsKey(c)) {
                for (char ch : map.get(c)) {
                    if (--degree[ch - 'a'] == 1) {
                        queue.offer(ch);
                    }
                }
            }
        }

        if (res.length() != count) return "";
        return res.toString();
    }
}
