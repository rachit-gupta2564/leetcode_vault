// Last updated: 22/09/2025, 16:15:40
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }
            Node next = curr.next;
            Node child = flatten(curr.child);
            curr.child = null;
            curr.next = child;
            child.prev = curr;
            Node tail = child;
            while (tail.next != null) tail = tail.next;
            tail.next = next;
            if (next != null) next.prev = tail;
            curr = next;
        }
        return head;
    }
}
