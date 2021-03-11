package LinkedList.cycleList;

import LinkedList.ListNode;

/**
 * @Auther: 99615
 * @Date: 2021/1/26 16:24
 * @Description:
 */
public class detectCycle {
    public ListNode Solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode tmp = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (tmp != slow) {
                    slow = slow.next;
                    tmp = tmp.next;
                }
                return slow;
            }
        }
        return null;
    }
}
