// Last updated: 22/09/2025, 16:18:31
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                int best = Integer.MAX_VALUE;
                for (int x = i; x <= j; x++) {
                    int cost = x + Math.max(dp[i][x - 1], dp[x + 1][j]);
                    best = Math.min(best, cost);
                }
                dp[i][j] = best;
            }
        }
        return dp[1][n];
    }
}
