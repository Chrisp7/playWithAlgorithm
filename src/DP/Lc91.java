package DP;

public class Lc91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] res = new int[len + 1];
        res[0] = 1;
        res[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= len; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9)
                res[i] += res[i - 1];
            if (second >= 10 && second <= 26)
                res[i] += res[i - 2];

        }
        return res[len];
    }
}
