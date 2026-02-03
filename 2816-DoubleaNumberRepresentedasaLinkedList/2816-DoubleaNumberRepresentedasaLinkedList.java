// Last updated: 03/02/2026, 19:36:52
1class Solution {
2    public ListNode doubleIt(ListNode head) {
3        head = reverse(head);
4
5        int carry = 0;
6        ListNode curr = head;
7        ListNode prev = null;
8
9        while (curr != null) {
10            int x = curr.val * 2 + carry;
11            curr.val = x % 10;
12            carry = x / 10;
13            prev = curr;
14            curr = curr.next;
15        }
16
17        if (carry != 0) {
18            prev.next = new ListNode(carry);
19        }
20
21        return reverse(head);
22    }
23
24    private ListNode reverse(ListNode head) {
25        ListNode prev = null, curr = head;
26        while (curr != null) {
27            ListNode next = curr.next;
28            curr.next = prev;
29            prev = curr;
30            curr = next;
31        }
32        return prev;
33    }
34}
35