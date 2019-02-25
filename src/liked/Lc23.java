package liked;

import java.util.*;

public class Lc23 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode Dummy = new ListNode(0);
        ListNode curDummy = Dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            curDummy.next = queue.poll();
            curDummy = curDummy.next;
            if (curDummy.next != null) {
                queue.add(curDummy.next);
            }
        }
        return Dummy.next;
    }
}
