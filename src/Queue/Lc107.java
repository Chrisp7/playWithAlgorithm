package Queue;
import java.util.*;

/**
 * Created by CP on 2018/12/5.
 */
public class Lc107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                l.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(0, l);
        }
        return res;
    }
}
