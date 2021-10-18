package Offer22;

import org.junit.Test;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/9/1 19:42
 * @Version 1.0
 **/

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {

        return getNode(head, k);
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);


        ListNode node = getNode(head, 0);
        System.out.println(node.val);
    }

    public ListNode getNode(ListNode head, int k) {
        int length = getLength(head);
        ListNode temp = head;
        if (k > length || k == 0) {
            return null;
        } else {
            int searchTime = length - k;
            for (int i = 0; i < searchTime; i++) {
                temp = temp.next;
            }
        }
        return temp;
    }


    public int getLength(ListNode head) {
        if (head == null) return 0;
        ListNode temp = head;
        int length = 0;

        while (true) {
            if (temp == null) {
                break;
            } else if (temp != null) {
                length++;
                temp = temp.next;
            }
        }
        return length;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
