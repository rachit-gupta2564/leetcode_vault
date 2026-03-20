// Last updated: 20/03/2026, 19:57:19
1import java.util.*;
2
3class Solution {
4    public int[][] minAbsDiff(int[][] grid, int k) {
5        int m = grid.length, n = grid[0].length;
6        int[][] ans = new int[m - k + 1][n - k + 1];
7
8        for (int i = 0; i <= m - k; i++) {
9            for (int j = 0; j <= n - k; j++) {
10                TreeSet<Integer> set = new TreeSet<>();
11
12                for (int r = i; r < i + k; r++) {
13                    for (int c = j; c < j + k; c++) {
14                        set.add(grid[r][c]);
15                    }
16                }
17
18                if (set.size() <= 1) {
19                    ans[i][j] = 0;
20                    continue;
21                }
22
23                int prev = 0;
24                boolean first = true;
25                int minDiff = Integer.MAX_VALUE;
26
27                for (int val : set) {
28                    if (first) {
29                        prev = val;
30                        first = false;
31                    } else {
32                        minDiff = Math.min(minDiff, val - prev);
33                        prev = val;
34                    }
35                }
36
37                ans[i][j] = minDiff;
38            }
39        }
40
41        return ans;
42    }
43}
44