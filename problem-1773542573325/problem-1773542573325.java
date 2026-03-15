// Last updated: 15/03/2026, 08:12:53
1class Solution {
2    public long countCommas(long n) {
3        long ans = 0;
4        long start = 1000L;
5        int commas = 1;
6        while (start <= n) {
7            long end = Math.min(n, start * 1000L - 1);
8            ans += (end - start + 1) * commas;
9            if (start > n / 1000L) {
10                break;
11            }
12            start *= 1000L;
13            commas ++;
14        }
15        return ans;
16    }
17}