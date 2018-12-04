package Stack;

import java.util.*;

/**
 * Created by CP on 2018/12/4.
 */
public class Lc20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;

                char match = ' ';
                if (ch == ')') match = '(';
                else if (ch == '}') match = '{';
                else match = '[';
                char top = stack.pop();
                if (top != match) return false;
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }
}
