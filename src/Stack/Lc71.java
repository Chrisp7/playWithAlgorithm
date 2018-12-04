package Stack;

import java.util.*;

/**
 * Created by CP on 2018/12/4.
 */
public class Lc71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/+");
        for (String s : str) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) stack.push(s);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) return "/";

        return res;
    }
}
