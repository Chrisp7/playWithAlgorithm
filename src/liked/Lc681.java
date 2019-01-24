package liked;

import java.util.*;

public class Lc681 {
    public String nextClosestTime(String time) {
        String[] val = time.split(":");
        Set<Integer> set = new HashSet<>();

        int hour = add(set, val[0]);
        int min = add(set, val[1]);
        int[] t = {hour, min};
        next(t);

        while (!contains(t, set)) {
            next(t);
        }
        return valid(t[0]) + ":" + valid(t[1]);
    }

    private int add(Set<Integer> set, String t) {
        int temp = Integer.parseInt(t);
        set.add(temp / 10);
        set.add(temp % 10);
        return temp;
    }

    private void next(int[] t) {
        int hour = t[0];
        int min = t[1];

        min++;
        if (min == 60) {
            hour++;
            min = 0;
            if (hour == 24) hour = 0;
        }
        t[0] = hour;
        t[1] = min;
    }

    private boolean contains(int[] t, Set<Integer> set) {
        int hour = t[0];
        int min = t[1];
        return set.contains(hour / 10) && set.contains(hour % 10) && set.contains(min / 10) && set.contains(min % 10);
    }

    private String valid(int val) {
        if (val >= 0 && val <= 9) return "0" + val;
        else return val + "";
    }

}
