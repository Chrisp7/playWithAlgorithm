package Stack;

import java.util.*;

/**
 * Created by CP on 2018/12/4.
 */



public class Lc144 {
    public class Command {
        public String s;
        public TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("visit", root));
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        while (!stack.isEmpty()) {
            Command t = stack.pop();
            if (t.s.equals("visit")) {
                if (t.node.right != null) stack.push(new Command("visit", t.node.right));
                if (t.node.left != null) stack.push(new Command("visit", t.node.left));
                stack.push(new Command("print", t.node));
            } else {
                res.add(t.node.val);
            }
        }
        return res;
    }
}
