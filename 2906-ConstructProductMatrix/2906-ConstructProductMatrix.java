// Last updated: 25/03/2026, 00:28:20
1class Solution {
2    public int[][] constructProductMatrix(int[][] grid) {
3        final int MOD = 12345;
4        int n = grid.length, m = grid[0].length;
5        int[][] ans = new int[n][m];
6
7        long suf = 1;
8        for (int i = n - 1; i >= 0; i--) {
9            for (int j = m - 1; j >= 0; j--) {
10                ans[i][j] = (int) suf;
11                suf = (suf * grid[i][j]) % MOD;
12            }
13        }
14
15        long pre = 1;
16        for (int i = 0; i < n; i++) {
17            for (int j = 0; j < m; j++) {
18                ans[i][j] = (int) ((ans[i][j] * pre) % MOD);
19                pre = (pre * grid[i][j]) % MOD;
20            }
21        }
22
23        return ans;
24    }
25}
26