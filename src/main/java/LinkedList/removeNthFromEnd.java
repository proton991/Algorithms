package LinkedList;

/**
 * @Auther: 99615
 * @Date: 2021/1/26 15:43
 * @Description:
 */
public class removeNthFromEnd {
    public ListNode Solution(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode fast, slow;
        slow = head;
        fast = head;
        int count = 0;
        while (count != n && fast.next != null) {
            fast = fast.next;
            count++;
        }
        if (count == n-1) {
            return head.next;
        }
        if (count < n)
            return null;
        while (fast.next != null && slow != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
