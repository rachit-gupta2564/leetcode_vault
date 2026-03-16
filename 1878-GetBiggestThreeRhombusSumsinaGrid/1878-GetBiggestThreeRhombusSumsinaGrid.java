// Last updated: 17/03/2026, 00:48:19
1import java.util.*;
2
3class Solution {
4    public int[] getBiggestThree(int[][] grid) {
5        int m = grid.length, n = grid[0].length;
6        TreeSet<Integer> top = new TreeSet<>();
7
8        for (int r = 0; r < m; r++) {
9            for (int c = 0; c < n; c++) {
10                add(top, grid[r][c]); // k = 0
11
12                int maxRadius = Math.min(Math.min(r, m - 1 - r), Math.min(c, n - 1 - c));
13
14                for (int k = 1; k <= maxRadius; k++) {
15                    int sum = 0;
16
17                    // top -> right
18                    int x = r - k, y = c;
19                    for (int i = 0; i < k; i++) {
20                        sum += grid[x + i][y + i];
21                    }
22
23                    // right -> bottom
24                    x = r;
25                    y = c + k;
26                    for (int i = 0; i < k; i++) {
27                        sum += grid[x + i][y - i];
28                    }
29
30                    // bottom -> left
31                    x = r + k;
32                    y = c;
33                    for (int i = 0; i < k; i++) {
34                        sum += grid[x - i][y - i];
35                    }
36
37                    // left -> top
38                    x = r;
39                    y = c - k;
40                    for (int i = 0; i < k; i++) {
41                        sum += grid[x - i][y + i];
42                    }
43
44                    add(top, sum);
45                }
46            }
47        }
48
49        int[] ans = new int[top.size()];
50        int idx = ans.length - 1;
51        for (int val : top) {
52            ans[idx--] = val;
53        }
54        return ans;
55    }
56
57    private void add(TreeSet<Integer> top, int val) {
58        top.add(val);
59        if (top.size() > 3) {
60            top.pollFirst();
61        }
62    }
63}
64