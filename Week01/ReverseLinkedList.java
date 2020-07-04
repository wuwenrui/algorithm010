/**
 * <p>
 *     反转一个单链表。
 *     输入: 1->2->3->4->5->NULL
 *     输出: 5->4->3->2->1->NULL
 * </p>
 *
 * public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) { val = x; }
 *  }
 *
 */
public class ReverseLinkedList{

    /**
     * 时间复杂度：O(n)
     * 空间复杂度： O(1)
     */
    private ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode tempNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNext;
        }
        return prev;
    }

}