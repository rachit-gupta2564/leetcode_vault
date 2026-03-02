// Last updated: 02/03/2026, 11:08:17
1class Solution {
2    public int minSwaps(int[][] grid) {
3        int n = grid.length;
4        int[] tz = new int[n];
5
6        // trailing zeros per row
7        for (int i = 0; i < n; i++) {
8            int cnt = 0;
9            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) cnt++;
10            tz[i] = cnt;
11        }
12
13        int swaps = 0;
14
15        for (int i = 0; i < n; i++) {
16            int need = n - 1 - i;
17
18            int j = i;
19            while (j < n && tz[j] < need) j++;
20            if (j == n) return -1;
21
22            // bubble row j up to i
23            while (j > i) {
24                int tmp = tz[j];
25                tz[j] = tz[j - 1];
26                tz[j - 1] = tmp;
27                swaps++;
28                j--;
29            }
30        }
31
32        return swaps;
33    }
34}
35