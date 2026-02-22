// Last updated: 22/02/2026, 09:13:38
1class Solution {
2    public int binaryGap(int n) {
3        int last = -1;
4        int pos = 0;
5        int ans = 0;
6
7        while (n != 0) {
8            if ((n & 1) == 1) {
9                if (last != -1) ans = Math.max(ans, pos - last);
10                last = pos;
11            }
12            n >>= 1;
13            pos++;
14        }
15
16        return ans;
17    }
18}
19