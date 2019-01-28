package liked;

import java.util.*;

public class Lc844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> forS = new Stack<>();
        Stack<Character> forT = new Stack<>();

        char[] unitS = S.toCharArray();
        char[] unitT = T.toCharArray();

        for (char ch : unitS) {
            if (ch == '#') {
                if (forS.isEmpty()) continue;
                forS.pop();
            } else forS.push(ch);
        }
        for (char ch : unitT) {
            if (ch == '#') {
                if (forT.isEmpty()) continue;
                forT.pop();
            } else forT.push(ch);
        }

        if (forS.size() != forT.size()) return false;
        for (int i = 0; i < forS.size(); i++) {
            if (forS.pop() != forT.pop()) return false;
        }
        return true;
    }

}
