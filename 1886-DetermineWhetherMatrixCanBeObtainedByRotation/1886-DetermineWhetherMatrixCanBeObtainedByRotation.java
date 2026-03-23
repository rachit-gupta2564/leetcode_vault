// Last updated: 24/03/2026, 01:21:32
1class Solution {
2    public boolean findRotation(int[][] mat, int[][] target) {
3        for (int i = 0; i < 4; i++) {
4            if (isEqual(mat, target)) {
5                return true;
6            }
7            rotate(mat);
8        }
9        return false;
10    }
11
12    private boolean isEqual(int[][] mat, int[][] target) {
13        int n = mat.length;
14        for (int i = 0; i < n; i++) {
15            for (int j = 0; j < n; j++) {
16                if (mat[i][j] != target[i][j]) {
17                    return false;
18                }
19            }
20        }
21        return true;
22    }
23
24    private void rotate(int[][] mat) {
25        int n = mat.length;
26
27        for (int layer = 0; layer < n / 2; layer++) {
28            int first = layer;
29            int last = n - 1 - layer;
30
31            for (int i = first; i < last; i++) {
32                int offset = i - first;
33
34                int top = mat[first][i];
35
36                mat[first][i] = mat[last - offset][first];
37                mat[last - offset][first] = mat[last][last - offset];
38                mat[last][last - offset] = mat[i][last];
39                mat[i][last] = top;
40            }
41        }
42    }
43}
44