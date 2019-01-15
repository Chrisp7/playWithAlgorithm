package Tree;
import java.util.*;

public class Lc77 {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        getCombination(n, k, 1, new ArrayList<>());
        return res;
    }

    private void getCombination(int n, int k, int start, List<Integer> ret) {
        if (ret.size() == k) {
            res.add(new ArrayList<>(ret));
            return;
        }

        for (int i = start; i < n + 1; i++) {
            ret.add(i);
            getCombination(n, k, i + 1, ret);
            ret.remove(ret.size() - 1);
        }
    }
}
