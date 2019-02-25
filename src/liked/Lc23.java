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

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] lists, int low, int high) {
        if (low >= high) return lists[low];
        int mid = (high - low) / 2 + low;
        ListNode left = sort(lists, low, mid);
        ListNode right = sort(lists, mid + 1, high);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

}
