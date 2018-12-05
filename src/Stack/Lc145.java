package Stack;

/**
 * Created by CP on 2018/12/4.
 */

import java.util.*;

public class Lc145 {
    public class Command {
        public String s;
        public TreeNode node;

        public Command(String s, TreeNode node) {
            s = s;
            node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("visit", root));
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        while (!stack.isEmpty()) {
            Command t = stack.pop();
            if (t.s.equals("visit")) {
                stack.push(new Command("print", t.node));
                if (t.node.right != null) stack.push(new Command("visit", t.node.right));
                if (t.node.left != null) stack.push(new Command("visit", t.node.left));
            } else {
                res.add(t.node.val);
            }
        }
        return res;
    }
}
