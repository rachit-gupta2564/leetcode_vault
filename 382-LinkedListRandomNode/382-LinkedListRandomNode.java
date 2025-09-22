// Last updated: 22/09/2025, 16:18:24
import java.util.*;

class Solution {
    private final List<Integer> values;
    private final Random rand;

    public Solution(ListNode head) {
        values = new ArrayList<>();
        rand = new Random();
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
    }

    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}
