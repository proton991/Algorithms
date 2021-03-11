package LinkedList;

/**
 * @Auther: 99615
 * @Date: 2021/1/26 16:44
 * @Description:
 */
public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pA, pB;
        pA = headA;
        pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return null;
    }
}
