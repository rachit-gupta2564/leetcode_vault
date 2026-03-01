// Last updated: 01/03/2026, 08:30:52
1class Solution {
2    public int minCost(int n) {
3        int[] dp = new int[n + 1];
4        for (int i = 2; i <= n; i ++) {
5            int ans = Integer.MAX_VALUE;
6            for (int j = 1; j < i; j ++) {
7                int b = i - j;
8                int cost = dp[j] + dp[b] + j * b;
9                if (cost < ans) {
10                    ans = cost;
11                }
12            }
13            dp[i] = ans;
14        }
15        return dp[n];
16    }
17}