package liked;

import java.util.*;

public class Lc703 {
    private PriorityQueue<Integer> pq;
    private int k;

    public Lc703(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int t : nums) {
            add(t);
        }
    }

    public int add(int val) {
        if (pq.size() < k) pq.offer(val);
        else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }


}
