package Offer24;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/9/1 19:42
 * @Version 1.0
 **/

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }else if (head.next == null){
            return head;
        }else {
            head = reverse(null, head, head.next);
            return head;
        }
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
/*        head.next = new ListNode(2);
        head.next.next = new ListNode(3);*/

        head = reverse(null, head, head.next);
        System.out.println(666);

    }

    public ListNode reverse(ListNode pre, ListNode cur, ListNode nxt) {
        cur.next = pre;

        if (nxt == null) {
            return cur;
        }

        pre = cur;
        cur = nxt;
        nxt = nxt.next;

        return reverse(pre, cur, nxt);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
