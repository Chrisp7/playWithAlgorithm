package LinkedList;

import java.util.*;

/**
 * Created by CP on 27/11/2018.
 */
/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

public class Lc445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        Stack<ListNode> reStack = new Stack<ListNode>();
        ListNode resultHead = new ListNode(0);
        ListNode result = resultHead;
        int sum = 0;
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) {
                ListNode t1 = s1.pop();
                sum += t1.val;
            }
            if (!s2.empty()) {
                ListNode t2 = s2.pop();
                sum += t2.val;
            }
            ListNode temp = new ListNode(sum % 10);
            reStack.push(temp);
            sum = sum / 10;
        }
        if (sum == 1)
            reStack.push(new ListNode(1));
        while (!reStack.empty()) {
            result.next = reStack.pop();
            result = result.next;
        }
        return resultHead.next;

    }
}
