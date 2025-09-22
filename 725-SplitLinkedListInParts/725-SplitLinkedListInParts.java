// Last updated: 22/09/2025, 16:15:48
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        
        int partSize = length / k;
        int extra = length % k;
        ListNode[] result = new ListNode[k];
        curr = head;
        
        for (int i = 0; i < k; i++) {
            ListNode partHead = curr;
            ListNode prev = null;
            int currentPartSize = partSize + (i < extra ? 1 : 0);
            for (int j = 0; j < currentPartSize; j++) {
                prev = curr;
                if (curr != null) curr = curr.next;
            }
            if (prev != null) prev.next = null;
            result[i] = partHead;
        }
        
        return result;
    }
}
