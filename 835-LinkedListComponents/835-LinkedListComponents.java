// Last updated: 22/09/2025, 16:15:27
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int count = 0;
        boolean inComponent = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!inComponent) {
                    count++;
                    inComponent = true;
                }
            } else {
                inComponent = false;
            }
            head = head.next;
        }
        return count;
    }
}
