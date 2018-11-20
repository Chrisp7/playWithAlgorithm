package LinkedList;

/**
 * Created by CP on 20/11/2018.
 */
public class Lc92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode cur = Dummy.next;
        ListNode pre = Dummy;
        for (int i = 1; i < m; i++) {
            cur = cur.next;
            pre = pre.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = pre.next;
            pre.next = t;
        }
        return Dummy.next;
    }
}
