// Last updated: 22/09/2025, 16:14:36
import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int moves = 0, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                int inc = prev - nums[i] + 1;
                moves += inc;
                nums[i] = prev + 1;
            }
            prev = nums[i];
        }
        return moves;
    }
}
