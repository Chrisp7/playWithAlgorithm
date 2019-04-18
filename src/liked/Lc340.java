package liked;

public class Lc340 {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] freq = new int[256];
        int res = 0, diff_num = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)]++ == 0) diff_num++;
            if (diff_num > k) {
                while (--freq[s.charAt(j)] > 0) ;
                diff_num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
