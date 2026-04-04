// Last updated: 04/04/2026, 17:58:09
1class Solution {
2    public int maximumAmount(int[][] coins) {
3        int m = coins.length;
4        int n = coins[0].length;
5        int NEG = Integer.MIN_VALUE / 4;
6
7        int[][][] dp = new int[m][n][3];
8
9        for (int i = 0; i < m; i++) {
10            for (int j = 0; j < n; j++) {
11                for (int k = 0; k < 3; k++) {
12                    dp[i][j][k] = NEG;
13                }
14            }
15        }
16
17        // Base case
18        if (coins[0][0] >= 0) {
19            dp[0][0][0] = coins[0][0];
20        } else {
21            dp[0][0][0] = coins[0][0]; // don't neutralize
22            dp[0][0][1] = 0;           // neutralize start cell
23        }
24
25        for (int i = 0; i < m; i++) {
26            for (int j = 0; j < n; j++) {
27                if (i == 0 && j == 0) continue;
28
29                for (int k = 0; k < 3; k++) {
30                    int bestPrev = NEG;
31
32                    if (i > 0) bestPrev = Math.max(bestPrev, dp[i - 1][j][k]);
33                    if (j > 0) bestPrev = Math.max(bestPrev, dp[i][j - 1][k]);
34
35                    // Do not neutralize current cell
36                    if (bestPrev != NEG) {
37                        dp[i][j][k] = Math.max(dp[i][j][k], bestPrev + coins[i][j]);
38                    }
39
40                    // Neutralize current cell if negative
41                    if (coins[i][j] < 0 && k > 0) {
42                        int bestPrevNeutral = NEG;
43
44                        if (i > 0) bestPrevNeutral = Math.max(bestPrevNeutral, dp[i - 1][j][k - 1]);
45                        if (j > 0) bestPrevNeutral = Math.max(bestPrevNeutral, dp[i][j - 1][k - 1]);
46
47                        if (bestPrevNeutral != NEG) {
48                            dp[i][j][k] = Math.max(dp[i][j][k], bestPrevNeutral);
49                        }
50                    }
51                }
52            }
53        }
54
55        return Math.max(dp[m - 1][n - 1][0],
56               Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
57    }
58}