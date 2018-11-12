package Array;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by CP on 11/11/2018.
 */
public class Lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[256];
        List<Integer> res = new ArrayList<>();

        int l = 0;
        while (l < s.length() - p.length() ) {
            for (int i = 0; i < p.length(); i++) {
                freq[p.charAt(i)] =0;
            }
            for (int i = 0; i < p.length(); i++) {
                freq[p.charAt(i)] ++;
            }
            search:
            {
                for (int i = l; i < l + p.length(); i++) {
                    if (freq[s.charAt(i)] == 0) break search;
                    else freq[s.charAt(i)]--;
                }
                res.add(l);
            }

            l++;
        }
        return res;
    }
}
