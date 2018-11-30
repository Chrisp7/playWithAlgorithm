package LinkedList;

/**
 * Created by CP on 2018/11/29.
 */
public class Lc24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        while(pre.next!=null&&pre.next.next!=null){
            ListNode cur=pre.next;
            ListNode curNext=cur.next;
            ListNode tail=curNext.next;

            cur.next=tail;
            curNext.next=cur;
            pre.next=curNext;

            pre=cur;
        }
        return dummy.next;
    }
}
