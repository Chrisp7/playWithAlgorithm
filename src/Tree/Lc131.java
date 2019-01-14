package Tree;

import java.util.*;

public class Lc131 {
    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        palindromePartition(s, res, ret);
        return res;
    }

    private void palindromePartition(String s, List<List<String>> res, List<String> ret) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(ret));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i + 1);
            if (isPalindrome(temp)) {
                ret.add(temp);
                palindromePartition(s.substring(i + 1), res, ret);
                ret.remove(ret.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        // reverse the given String
        String reverse = new StringBuffer(str).reverse().toString();
        // check whether the string is palindrome or not
        return str.equals(reverse) ? true : false;
    }
}
