package LinkedList;

/**
 * Created by CP on 2018/11/29.
 */
public class Lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode countHead=head;
        while(countHead!=null){
            length+=1;
            countHead=countHead.next;
        }
        int count = length / k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < count; i++) {
            int innerCount = 0;
            ListNode cur = pre.next;
            while (innerCount < k - 1 && cur.next != null) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;

                innerCount++;
            }
            pre = cur;
        }
        return dummy.next;
    }

}
