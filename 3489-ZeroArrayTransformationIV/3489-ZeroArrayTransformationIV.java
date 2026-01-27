// Last updated: 27/01/2026, 18:43:41
1class Solution {
2    public int minZeroArray(int[] nums, int[][] queries) {
3        int n = nums.length;
4        boolean alreadyZero = true;
5        for (int v : nums) {
6            if (v != 0) {
7                alreadyZero = false;
8                break;
9            }
10        }
11        if (alreadyZero) return 0;
12
13        int maxTarget = 0;
14        for (int v : nums) maxTarget = Math.max(maxTarget, v);
15
16        boolean[][] dp = new boolean[n][maxTarget + 1];
17        for (int i = 0; i < n; i++) dp[i][0] = true;
18
19        for (int q = 0; q < queries.length; q++) {
20            int l = queries[q][0];
21            int r = queries[q][1];
22            int val = queries[q][2];
23
24            for (int i = l; i <= r; i++) {
25                for (int s = maxTarget; s >= val; s--) {
26                    if (dp[i][s - val]) dp[i][s] = true;
27                }
28            }
29
30            boolean ok = true;
31            for (int i = 0; i < n; i++) {
32                if (!dp[i][nums[i]]) {
33                    ok = false;
34                    break;
35                }
36            }
37            if (ok) return q + 1;
38        }
39        return -1;
40    }
41}
42