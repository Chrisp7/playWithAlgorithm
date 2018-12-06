package Queue;

import java.util.*;

/**
 * Created by CP on 2018/12/5.
 */
public class Lc102 {
    public class NodeWithLevel {
        TreeNode node;
        int level;

        public NodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 0));
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        while (!queue.isEmpty()) {
            NodeWithLevel cur = queue.remove();
            if (cur.node.left != null) queue.add(new NodeWithLevel(cur.node.left, cur.level + 1));
            if (cur.node.right != null) queue.add(new NodeWithLevel(cur.node.right, cur.level + 1));

            if (cur.level == res.size())
                res.add(new ArrayList<Integer>());
            res.get(cur.level).add(cur.node.val);

        }
        return res;
    }
}
