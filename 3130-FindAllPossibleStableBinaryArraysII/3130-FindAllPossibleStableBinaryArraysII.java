// Last updated: 10/03/2026, 09:54:03
1class Solution {
2    public int numberOfStableArrays(int zero, int one, int limit) {
3        final int MOD = 1_000_000_007;
4        long[][][] dp = new long[zero + 1][one + 1][2];
5
6        for (int i = 1; i <= Math.min(zero, limit); i++) {
7            dp[i][0][0] = 1;
8        }
9        for (int j = 1; j <= Math.min(one, limit); j++) {
10            dp[0][j][1] = 1;
11        }
12
13        for (int i = 1; i <= zero; i++) {
14            for (int j = 1; j <= one; j++) {
15                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
16                if (i - limit - 1 >= 0) {
17                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
18                }
19
20                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
21                if (j - limit - 1 >= 0) {
22                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
23                }
24            }
25        }
26
27        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
28    }
29}
30