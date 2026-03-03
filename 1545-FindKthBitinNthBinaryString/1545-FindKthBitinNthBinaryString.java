// Last updated: 04/03/2026, 00:08:10
1class Solution {
2    public char findKthBit(int n, int k) {
3        return dfs(n, k);
4    }
5
6    private char dfs(int n, int k) {
7        if (n == 1) return '0';
8
9        int len = (1 << n) - 1;      // |S_n|
10        int mid = 1 << (n - 1);      // middle position (1-indexed)
11
12        if (k == mid) return '1';
13
14        if (k < mid) {
15            return dfs(n - 1, k);
16        } else {
17            int mirrored = len - k + 1;
18            char c = dfs(n - 1, mirrored);
19            return (c == '0') ? '1' : '0';
20        }
21    }
22}
23