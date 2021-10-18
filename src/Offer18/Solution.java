package Offer18;

/**
 * @ClassName Solution
 * @Author dy
 * @Date 2021/9/1 12:26
 * @Version 1.0
 **/

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {

        if (head.val == val){
            return head.next;
        }

        ListNode fast = null;//使用快慢指针的方法
        ListNode slow = null;

        if (head == null){
            return null;
        }else if (head.next == null){
            return null;
        }else {
            fast = head.next;
            slow = head;
        }

        while (true){

            if (fast == null){
                break;
            }else if (fast.val == val){
                slow.next = fast.next;
                break;
            }

            fast = fast.next;
            slow = slow.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
