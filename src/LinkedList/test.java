package LinkedList;

/**
 * Created by CP on 2018/11/29.
 */
public class test {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode res = new Lc25().reverseKGroup(head, 3);
        ListNodeUtil.printList(res);

    }
}
