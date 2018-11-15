package Set;

import java.util.*;

/**
 * Created by CP on 15/11/2018.
 */
public class Lc454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                map.put(C[i] + D[j], map.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int res = 0;
        for (int k = 0; k < A.length; k++) {
            for (int h = 0; h < B.length; h++) {
                res += map.getOrDefault(-A[k] - B[h], 0);
            }
        }
        return res;
    }
}
