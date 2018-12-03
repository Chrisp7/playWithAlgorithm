package LinkedList;

/**
 * Created by CP on 2018/12/2.
 */
public class Lc237 {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next == null) node = null;

        node.val = node.next.val;
        node.next = node.next.next;

    }
}
