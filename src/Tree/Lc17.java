package Tree;

import java.util.*;

public class Lc17 {
    private final String[] letterMap = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    private List<String> res;

    private void findCombination(String digits, int index, String str) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }

        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, str + letters.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0 || digits == null) return res;
        findCombination(digits, 0, "");
        return res;
    }
}
