package LinkedList;

/**
 * Created by CP on 2018/11/29.
 */
public class test {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.createLinkedList(new int[]{-1, 5, 3, 4, 0, 4, 2, 5, 7});
        ListNode res = new Lc148().sortList(head);
        ListNodeUtil.printList(res);
    }
}
