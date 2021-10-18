package Offer25;

import org.junit.Test;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/9/1 21:18
 * @Version 1.0
 **/

public class Solution {
    @Test
    public void test() {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);

        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(888);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempL2 = l2;

        while (tempL2 != null){
            ListNode tempL1 = l1;
            ListNode pre = null;

            while (tempL1.val < tempL2.val){
                pre = tempL1;
                tempL1 = tempL1.next;
                if (tempL1 == null) break;
            }
            ListNode node = new ListNode(tempL2.val);
            if (pre == null){
                node.next = l1;
                l1 = node;
            }else {
                pre.next = node;
                node.next = tempL1;
            }

            tempL2 = tempL2.next;
        }
        return l1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

