// Last updated: 19/03/2026, 21:25:05
1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5        
6        long[][] pref = new long[m + 1][n + 1];
7        int count = 0;
8
9        for (int i = 1; i <= m; i++) {
10            for (int j = 1; j <= n; j++) {
11                pref[i][j] = pref[i - 1][j]
12                           + pref[i][j - 1]
13                           - pref[i - 1][j - 1]
14                           + grid[i - 1][j - 1];
15
16                if (pref[i][j] <= k) {
17                    count++;
18                }
19            }
20        }
21
22        return count;
23    }
24}
25