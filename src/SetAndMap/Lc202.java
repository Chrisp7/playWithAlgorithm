package SetAndMap;

import java.util.*;

/**
 * Created by CP on 13/11/2018.
 */
public class Lc202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (set.add(n)) {
            int squareSum = 0;
            int e = 0;
            while (n != 0) {
                e = n % 10;
                squareSum += e * e;
                n = n / 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;
        }
        return false;
    }
}
