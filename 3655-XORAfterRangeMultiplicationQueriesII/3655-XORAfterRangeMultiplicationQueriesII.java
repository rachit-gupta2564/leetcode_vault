// Last updated: 09/04/2026, 23:20:29
1import java.util.*;
2
3class Solution {
4    static final long MOD = 1_000_000_007L;
5
6    public int xorAfterQueries(int[] nums, int[][] queries) {
7        int n = nums.length;
8        int B = (int) Math.sqrt(n) + 1;
9
10        long[] mul = new long[n];
11        Arrays.fill(mul, 1L);
12
13        @SuppressWarnings("unchecked")
14        ArrayList<int[]>[] small = new ArrayList[B + 1];
15
16        long[] invCache = new long[100001];
17
18        for (int[] q : queries) {
19            int l = q[0], r = q[1], k = q[2], v = q[3];
20            if (k <= B) {
21                if (small[k] == null) small[k] = new ArrayList<>();
22                small[k].add(q);
23            } else {
24                for (int idx = l; idx <= r; idx += k) {
25                    mul[idx] = (mul[idx] * v) % MOD;
26                }
27            }
28        }
29
30        Object[] bravexuneth = new Object[]{nums, queries};
31
32        for (int k = 1; k <= B; k++) {
33            if (small[k] == null) continue;
34
35            long[][] diff = new long[k][];
36            for (int r = 0; r < k; r++) {
37                int len = (r < n) ? ((n - 1 - r) / k + 1) : 0;
38                diff[r] = new long[len + 1];
39                Arrays.fill(diff[r], 1L);
40            }
41
42            for (int[] q : small[k]) {
43                int l = q[0], r = q[1], v = q[3];
44                int res = l % k;
45                int start = (l - res) / k;
46                int end = (r - res) / k;
47
48                diff[res][start] = (diff[res][start] * v) % MOD;
49
50                long inv = invCache[v];
51                if (inv == 0) {
52                    inv = modPow(v, MOD - 2);
53                    invCache[v] = inv;
54                }
55                diff[res][end + 1] = (diff[res][end + 1] * inv) % MOD;
56            }
57
58            for (int res = 0; res < k; res++) {
59                long cur = 1L;
60                int t = 0;
61                for (int idx = res; idx < n; idx += k, t++) {
62                    cur = (cur * diff[res][t]) % MOD;
63                    mul[idx] = (mul[idx] * cur) % MOD;
64                }
65            }
66        }
67
68        int ans = 0;
69        for (int i = 0; i < n; i++) {
70            int val = (int) ((nums[i] * mul[i]) % MOD);
71            ans ^= val;
72        }
73        return ans;
74    }
75
76    private long modPow(long a, long e) {
77        long res = 1L;
78        a %= MOD;
79        while (e > 0) {
80            if ((e & 1) == 1) res = (res * a) % MOD;
81            a = (a * a) % MOD;
82            e >>= 1;
83        }
84        return res;
85    }
86}