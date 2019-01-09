package Tree;

import java.util.*;

public class Lc257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null) return res;

        if (root.left == null && root.right == null) {
            res.add(root.val + "");
        }
        List<String> ll = binaryTreePaths(root.left);
        for (String s : ll) {
            res.add(root.val + "->" + s);
        }
        List<String> rl = binaryTreePaths(root.right);
        for (String s : rl) {
            res.add(root.val + "->" + s);
        }
        return res;

    }
}
