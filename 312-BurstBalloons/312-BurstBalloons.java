// Last updated: 22/09/2025, 16:19:36
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        for (int i = 0; i < n; i++) balloons[i + 1] = nums[i];
        
        int[][] dp = new int[n + 2][n + 2];
        
        for (int length = 1; length <= n; length++) {
            for (int left = 1; left <= n - length + 1; left++) {
                int right = left + length - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                        dp[left][k - 1] + balloons[left - 1] * balloons[k] * balloons[right + 1] + dp[k + 1][right]);
                }
            }
        }
        
        return dp[1][n];
    }
}
