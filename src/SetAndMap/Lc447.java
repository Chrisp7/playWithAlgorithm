package SetAndMap;

import java.util.*;

/**
 * Created by CP on 17/11/2018.
 */
public class Lc447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int d = distance(points[i], points[j]);
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
            for (Integer num : map.values()) {
                if (num >= 2)
                    res += num * (num - 1);
            }
        }
        return res;
    }

    private int distance(int[] pointA, int[] pointB) {
        return (pointA[0] - pointB[0]) * (pointA[0] - pointB[0]) + (pointA[1] - pointB[1]) * (pointA[1] - pointB[1]);
    }
}
