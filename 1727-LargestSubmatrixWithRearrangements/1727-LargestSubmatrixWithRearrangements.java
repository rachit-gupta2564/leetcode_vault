// Last updated: 17/03/2026, 22:48:24
1import java.util.Arrays;
2
3class Solution {
4    public int largestSubmatrix(int[][] matrix) {
5        int m = matrix.length;
6        int n = matrix[0].length;
7
8        int[] hist = new int[n];
9        int ans = 0;
10
11        for (int[] row : matrix) {
12            for (int i = 0; i < n; i++) {
13                hist[i] = (row[i] == 0) ? 0 : hist[i] + 1;
14            }
15
16            int[] sorted = hist.clone();
17            Arrays.sort(sorted);
18
19            for (int i = 0; i < n; i++) {
20                ans = Math.max(ans, sorted[i] * (n - i));
21            }
22        }
23
24        return ans;
25    }
26}
27