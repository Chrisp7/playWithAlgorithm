package LinkedList;

/**
 * Created by CP on 2018/11/29.
 */
public class test {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.createLinkedList(new int[]{-1, 5, 3, 4, 0});
        ListNode res = new Lc147().insertionSortList(head);
        ListNodeUtil.printList(res);

    }
}
