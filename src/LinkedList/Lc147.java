package LinkedList;

/**
 * Created by CP on 2018/11/29.
 */
public class Lc147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur.next != null) {
            if (cur.next.val < cur.val) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;

                ListNode p = pre;
                while (temp.val > temp.next.val) {
                    ListNode next = temp.next;

                    temp.next = next.next;
                    next.next = p.next;
                    p.next = next;

                    p = p.next;
                }
            }
            else cur=cur.next;
        }
        return dummy.next;
    }
}
