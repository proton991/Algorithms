package LinkedList.reverseList;

import LinkedList.ListNode;

/**
 * @Auther: 99615
 * @Date: 2021/1/26 14:20
 * @Description:
 */
public class reverseList_Recursive {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
