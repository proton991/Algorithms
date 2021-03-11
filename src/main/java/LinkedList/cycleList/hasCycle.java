package LinkedList.cycleList;

import LinkedList.ListNode;

/**
 * @Auther: 99615
 * @Date: 2021/1/26 16:24
 * @Description:
 */
public class hasCycle {

    public boolean Solution(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
