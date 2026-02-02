// Last updated: 02/02/2026, 12:04:58
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head, slow_prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow_prev = slow;
            slow = slow.next;
        }
        slow_prev.next = slow.next;
        slow.next = null;
        System.gc();
        return head;
    }
}