package liked;

import java.util.*;

public class Lc146 {
    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public Lc146(int capacity) {
        map = new HashMap<>();
        head = null;
        tail = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.next = null;
            node.pre = tail;
            tail.next = node;
            tail = node;
        }
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                node.next = null;
                node.pre = tail;
                tail.next = node;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                map.remove(head.key);
                head = head.next;
                capacity++;
            }
            if (head == null && tail == null) {
                head = newNode;
            } else {
                newNode.pre = tail;
                tail.next = newNode;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }
}
