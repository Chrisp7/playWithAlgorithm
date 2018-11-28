package LinkedList;

/**
 * Created by CP on 28/11/2018.
 */
public class Lc203 {
    public ListNode removeElements(ListNode head, int val) {
    /*
        if(head==null){
            return head;
        }else{
            if (head.val==val){
                return removeElements(head.next,val);
            }else {
                head.next=removeElements(head.next,val);
                return head;
            }
        }
    */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode = null;
            } else
                cur = cur.next;
        }
        return dummy.next;

    }
}
