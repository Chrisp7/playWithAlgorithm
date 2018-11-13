package Array;

/**
 * Created by CP on 13/11/2018.
 */
public class Lc3 {
    public int lengthOfLongestSubstring(String s) {
        int[] freq=new int[256];
        int l=0;
        int r=-1;
        int res=0;
        while(l<s.length()){
            if(r+1<s.length()&&freq[s.charAt(r+1)]==0)
                freq[s.charAt(++r)]++;
            else
                freq[s.charAt(l++)]--;
            res=Math.max(res,r-l+1);
        }
        return res;
    }

}
