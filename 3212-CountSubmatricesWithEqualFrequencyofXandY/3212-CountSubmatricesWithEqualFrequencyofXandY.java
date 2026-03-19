// Last updated: 19/03/2026, 21:26:23
1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[][] x = new int[m + 1][n + 1];
7        int[][] y = new int[m + 1][n + 1];
8        int ans = 0;
9
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                x[i + 1][j + 1] = x[i][j + 1] + x[i + 1][j] - x[i][j] + (grid[i][j] == 'X' ? 1 : 0);
13                y[i + 1][j + 1] = y[i][j + 1] + y[i + 1][j] - y[i][j] + (grid[i][j] == 'Y' ? 1 : 0);
14
15                if (x[i + 1][j + 1] > 0 && x[i + 1][j + 1] == y[i + 1][j + 1]) {
16                    ans++;
17                }
18            }
19        }
20
21        return ans;
22    }
23}
24