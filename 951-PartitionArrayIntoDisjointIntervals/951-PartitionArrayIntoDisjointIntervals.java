// Last updated: 22/09/2025, 16:14:47
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        
        // Build the rightMin array: rightMin[i] stores the minimum from i to n-1.
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(nums[i], rightMin[i + 1]);
        }
        
        int leftMax = nums[0];
        // Traverse from the beginning to find the partition point.
        for (int i = 0; i < n - 1; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            if (leftMax <= rightMin[i + 1]) {
                return i + 1; // Partition index found (left subarray length)
            }
        }
        
        // Fallback return; however, constraints guarantee there is always a valid partition.
        return n;
    }
}