package LinkedList.reverseList;

import LinkedList.ListNode;

/**
 * @Auther: 99615
 * @Date: 2021/1/26 13:59
 * @Description:
 */
public class reverseList_Iterative {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
