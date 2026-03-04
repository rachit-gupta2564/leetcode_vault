// Last updated: 04/03/2026, 23:15:27
1class Solution {
2    public int numSpecial(int[][] mat) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        int[] rowSum = new int[m];
7        int[] colSum = new int[n];
8
9        // First pass: count 1s in each row and column
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                if (mat[i][j] == 1) {
13                    rowSum[i]++;
14                    colSum[j]++;
15                }
16            }
17        }
18
19        // Second pass: count special positions
20        int ans = 0;
21        for (int i = 0; i < m; i++) {
22            if (rowSum[i] != 1) continue; // small optimization
23            for (int j = 0; j < n; j++) {
24                if (mat[i][j] == 1 && colSum[j] == 1) {
25                    ans++;
26                }
27            }
28        }
29
30        return ans;
31    }
32}
33