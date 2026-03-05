// Last updated: 05/03/2026, 23:59:27
1class Solution {
2    public int minOperations(String s) {
3        int n = s.length();
4        int mismatchesStartWith0 = 0; // pattern: 010101...
5
6        for (int i = 0; i < n; i++) {
7            char expected = (i % 2 == 0) ? '0' : '1';
8            if (s.charAt(i) != expected) mismatchesStartWith0++;
9        }
10
11        int mismatchesStartWith1 = n - mismatchesStartWith0; // pattern: 101010...
12        return Math.min(mismatchesStartWith0, mismatchesStartWith1);
13    }
14}
15