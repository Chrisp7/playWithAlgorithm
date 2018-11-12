package Array;

/**
 * Created by CP on 12/11/2018.
 */
public class Lc76 {
    public String minWindow(String s, String t) {
        int[] freq_t = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freq_t[t.charAt(i)]++;
        }

        int total = t.length();
        int from = 0;
        int min = s.length() + 1;

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (freq_t[s.charAt(i)]-- > 0) total--;
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++freq_t[s.charAt(j++)] > 0) total++;
            }
        }
        return min==s.length()+1?"":s.substring(from,from+min);


    }
}
