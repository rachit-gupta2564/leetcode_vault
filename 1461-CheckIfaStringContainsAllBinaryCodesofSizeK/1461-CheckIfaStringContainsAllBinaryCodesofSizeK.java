// Last updated: 23/02/2026, 19:31:11
1class Solution {
2    public boolean hasAllCodes(String s, int k) {
3        int n = s.length();
4        if (k > n) return false;
5
6        int need = 1 << k;                 // number of codes = 2^k
7        if (n - k + 1 < need) return false;
8
9        boolean[] seen = new boolean[need];
10        int mask = need - 1;
11        int val = 0, count = 0;
12
13        for (int i = 0; i < n; i++) {
14            val = ((val << 1) & mask) | (s.charAt(i) - '0');
15            if (i >= k - 1) {
16                if (!seen[val]) {
17                    seen[val] = true;
18                    if (++count == need) return true;
19                }
20            }
21        }
22        return false;
23    }
24}
25