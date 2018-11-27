package LinkedList;

/**
 * Created by CP on 27/11/2018.
 */
public class Lc83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;

    }
}
