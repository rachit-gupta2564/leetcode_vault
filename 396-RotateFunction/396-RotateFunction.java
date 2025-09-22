// Last updated: 22/09/2025, 16:18:04
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0, F = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += i * nums[i];
        }
        int max = F;
        for (int i = n - 1; i >= 1; i--) {
            F = F + sum - n * nums[i];
            max = Math.max(max, F);
        }
        return max;
    }
}
