package liked;

import java.util.*;

public class Lc297 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                res.append("null ");
                continue;
            }
            res.append(temp.val + " ");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] strArr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < strArr.length; i++) {
            TreeNode temp = q.poll();
            if (!strArr[i].equals("null")) {
                temp.left = new TreeNode(Integer.parseInt(strArr[i]));
                q.offer(temp.left);
            }
            if (!strArr[++i].equals("null")) {
                temp.right = new TreeNode(Integer.parseInt(strArr[i]));
                q.offer(temp.right);
            }
        }
        return root;
    }
}
