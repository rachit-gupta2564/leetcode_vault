// Last updated: 16/09/2025, 23:15:26
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        head.next = deleteDuplicates(head.next);
        if (head.next != null && head.val == head.next.val) head.next = head.next.next;
        return head;
    }
}
