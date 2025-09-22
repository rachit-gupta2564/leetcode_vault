// Last updated: 22/09/2025, 16:15:17
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) return 1.0;
        if (n >= k + maxPts - 1) return 1.0;
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double window = 1.0;
        double res = 0.0;
        for (int i = 1; i <= n; i++) {
            dp[i] = window / maxPts;
            if (i < k) window += dp[i];
            else res += dp[i];
            if (i - maxPts >= 0) window -= dp[i - maxPts];
        }
        return res;
    }
}