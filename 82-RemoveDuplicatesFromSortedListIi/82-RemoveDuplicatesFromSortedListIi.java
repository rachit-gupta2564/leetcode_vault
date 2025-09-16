// Last updated: 16/09/2025, 23:15:28
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next != null && head.val == head.next.val) {
            int v = head.val;
            while (head != null && head.val == v) head = head.next;
            return deleteDuplicates(head);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
