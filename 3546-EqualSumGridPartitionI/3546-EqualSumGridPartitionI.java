// Last updated: 27/03/2026, 22:42:57
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        long total = 0;
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                total += grid[i][j];
10            }
11        }
12
13        if ((total & 1L) == 1L) return false;
14
15        long target = total / 2;
16        long prefix = 0;
17
18        // Check horizontal cuts
19        for (int i = 0; i < m - 1; i++) {
20            for (int j = 0; j < n; j++) {
21                prefix += grid[i][j];
22            }
23            if (prefix == target) return true;
24        }
25
26        // Check vertical cuts
27        prefix = 0;
28        for (int j = 0; j < n - 1; j++) {
29            for (int i = 0; i < m; i++) {
30                prefix += grid[i][j];
31            }
32            if (prefix == target) return true;
33        }
34
35        return false;
36    }
37}
38