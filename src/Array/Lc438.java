package Array;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by CP on 11/11/2018.
 */
public class Lc438 {
    /*
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
    */
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq_p=new int[26];
        for (int i=0;i<p.length();i++){
            freq_p[p.charAt(i)-'a']++;
        }
        int[] freq_s=new int[26];
        int l=0;
        int r=-1;
        List<Integer> res=new ArrayList<>(20);
        while(r+1<s.length()){
            freq_s[s.charAt(++r)-'a']++;
            if (r-l+1>p.length()) freq_s[s.charAt(l++)-'a']--;
            if(r-l+1==p.length()&&same(freq_p,freq_s)) res.add(l);
        }
        return res;

    }
    private boolean same(int[] freq_p,int[] freq_s){
        for (int i=0;i<26;i++)
            if (freq_p[i]!=freq_s[i])
                return false;
        return true;
    }
}
