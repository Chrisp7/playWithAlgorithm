package Tree;

import java.util.*;

public class Lc98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return helper(root, null, null);
        /*
        List<Integer> res=new ArrayList<>();

        inOrder(root,res);

        for(int i=0;i<res.size()-1;i++){
            if(res.get(i)>=res.get(i+1)) return false;
        }
        return true;
        */
    }

    private boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if (min != null && min >= node.val) return false;
        if (max != null && max <= node.val) return false;

        return helper(node.left, min, node.val) && helper(node.right, node.val, max);

    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;

        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }
}
