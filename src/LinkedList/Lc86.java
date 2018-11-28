package LinkedList;

/**
 * Created by CP on 27/11/2018.
 */

public class Lc86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead=new ListNode(0);
        ListNode bigHead=new ListNode(0);
        ListNode small=smallHead;
        ListNode big=bigHead;
        while(head!=null){
            ListNode temp=new ListNode(head.val);
            if(temp.val<x){
                small.next=temp;
                small=small.next;
            }else{
                big.next=temp;
                big=big.next;
            }
            head=head.next;
        }
        small.next=bigHead.next;
        return smallHead.next;
    }
}
