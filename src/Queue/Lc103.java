package Queue;

import java.util.*;

/**
 * Created by CP on 2018/12/5.
 */
public class Lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        boolean x = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (x) l.add(cur.val);
                else l.add(0, cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(l);
            x = x ? false : true;

        }
        return res;
    }
}
