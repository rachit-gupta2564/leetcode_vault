// Last updated: 09/03/2026, 18:17:16
1class Solution {
2    public int numberOfStableArrays(int zero, int one, int limit) {
3        final int MOD = 1_000_000_007;
4        long[][][] dp = new long[zero + 1][one + 1][2];
5
6        // Only zeros
7        for (int i = 0; i <= Math.min(zero, limit); i++) {
8            dp[i][0][0] = 1;
9        }
10
11        // Only ones
12        for (int j = 0; j <= Math.min(one, limit); j++) {
13            dp[0][j][1] = 1;
14        }
15
16        for (int i = 1; i <= zero; i++) {
17            for (int j = 1; j <= one; j++) {
18                dp[i][j][0] = (
19                    dp[i - 1][j][0] +
20                    dp[i - 1][j][1] -
21                    (i - limit < 1 ? 0 : dp[i - limit - 1][j][1]) +
22                    MOD
23                ) % MOD;
24
25                dp[i][j][1] = (
26                    dp[i][j - 1][0] +
27                    dp[i][j - 1][1] -
28                    (j - limit < 1 ? 0 : dp[i][j - limit - 1][0]) +
29                    MOD
30                ) % MOD;
31            }
32        }
33
34        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
35    }
36}
37