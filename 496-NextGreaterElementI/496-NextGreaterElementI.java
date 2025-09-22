// Last updated: 22/09/2025, 16:16:17
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // Build the next greater element mapping for nums2
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Remaining elements have no next greater element
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        // Fill the result for nums1 using the map
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreater.get(nums1[i]);
        }

        return res;
    }
}
