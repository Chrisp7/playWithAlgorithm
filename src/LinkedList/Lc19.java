package LinkedList;

/**
 * Created by CP on 2018/12/3.
 */
public class Lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        while (q != null) {
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;

        return dummy.next;
    }
}
