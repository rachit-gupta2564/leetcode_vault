// Last updated: 22/09/2025, 16:17:00
import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int third = Integer.MIN_VALUE; // nums[k] in "132" pattern
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) {
                // Found nums[i] < nums[k] < nums[j]
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                // nums[i] is potential nums[j], pop stack to update nums[k]
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        
        return false;
    }
}
