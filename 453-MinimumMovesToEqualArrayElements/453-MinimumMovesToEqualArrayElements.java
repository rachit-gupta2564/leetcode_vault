// Last updated: 22/09/2025, 16:17:04
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        long sum = 0; // use long to avoid overflow
        
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        
        // Total moves = sum of differences from minimum element
        return (int)(sum - (long)min * nums.length);
    }
}
