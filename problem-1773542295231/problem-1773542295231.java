// Last updated: 15/03/2026, 08:08:15
1class Solution {
2    public int countCommas(int n) {
3        long ans = 0;
4        long start = 1000;
5        int commas = 1;
6        while (start <= n) {
7            long end = Math.min((long) n, start * 1000 - 1);
8            ans += (end - start + 1) * commas;
9            start *= 1000;
10            commas ++;
11        }
12        return (int) ans;
13    }
14}