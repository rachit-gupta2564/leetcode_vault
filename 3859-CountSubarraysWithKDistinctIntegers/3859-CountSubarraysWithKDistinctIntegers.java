// Last updated: 02/03/2026, 11:05:33
1import java.util.Arrays;
2
3class Solution {
4
5    // Segment tree for range add, query count of zeros in a range.
6    static class SegTree {
7        int n;
8        int[] min, cntMin, lazy;
9
10        SegTree(int n) {
11            this.n = n;
12            min = new int[4 * n];
13            cntMin = new int[4 * n];
14            lazy = new int[4 * n];
15            build(1, 0, n - 1);
16        }
17
18        void build(int idx, int l, int r) {
19            min[idx] = 0;
20            cntMin[idx] = r - l + 1;
21            if (l == r) return;
22            int mid = (l + r) >>> 1;
23            build(idx << 1, l, mid);
24            build(idx << 1 | 1, mid + 1, r);
25        }
26
27        void apply(int idx, int delta) {
28            min[idx] += delta;
29            lazy[idx] += delta;
30        }
31
32        void push(int idx) {
33            int d = lazy[idx];
34            if (d != 0) {
35                apply(idx << 1, d);
36                apply(idx << 1 | 1, d);
37                lazy[idx] = 0;
38            }
39        }
40
41        void pull(int idx) {
42            int l = idx << 1, r = idx << 1 | 1;
43            int mn = Math.min(min[l], min[r]);
44            min[idx] = mn;
45            int c = 0;
46            if (min[l] == mn) c += cntMin[l];
47            if (min[r] == mn) c += cntMin[r];
48            cntMin[idx] = c;
49        }
50
51        void add(int L, int R, int delta) {
52            if (L > R) return;
53            add(1, 0, n - 1, L, R, delta);
54        }
55
56        void add(int idx, int l, int r, int L, int R, int delta) {
57            if (R < l || r < L) return;
58            if (L <= l && r <= R) {
59                apply(idx, delta);
60                return;
61            }
62            push(idx);
63            int mid = (l + r) >>> 1;
64            add(idx << 1, l, mid, L, R, delta);
65            add(idx << 1 | 1, mid + 1, r, L, R, delta);
66            pull(idx);
67        }
68
69        // returns int[]{minValue, countOfMin} on [L..R]
70        int[] query(int L, int R) {
71            if (L > R) return new int[]{1_000_000_000, 0};
72            return query(1, 0, n - 1, L, R);
73        }
74
75        int[] query(int idx, int l, int r, int L, int R) {
76            if (R < l || r < L) return new int[]{1_000_000_000, 0};
77            if (L <= l && r <= R) return new int[]{min[idx], cntMin[idx]};
78            push(idx);
79            int mid = (l + r) >>> 1;
80            int[] a = query(idx << 1, l, mid, L, R);
81            int[] b = query(idx << 1 | 1, mid + 1, r, L, R);
82            int mn = Math.min(a[0], b[0]);
83            int c = 0;
84            if (a[0] == mn) c += a[1];
85            if (b[0] == mn) c += b[1];
86            return new int[]{mn, c};
87        }
88
89        int zerosCount(int L, int R) {
90            int[] res = query(L, R);
91            return (res[0] == 0) ? res[1] : 0;
92        }
93    }
94
95    public long countSubarrays(int[] nums, int k, int m) {
96        if (k <= 0 || m <= 0) return 0;
97        if (m == 1) {
98            // Classic exactly-k-distinct
99            return atMostDistinct(nums, k) - atMostDistinct(nums, k - 1);
100        }
101        Precomp pc = new Precomp(nums);
102        return atMostKM(nums, k, m, pc) - atMostKM(nums, k - 1, m, pc);
103    }
104
105    private long atMostDistinct(int[] nums, int K) {
106        if (K <= 0) return 0;
107        int n = nums.length;
108        int maxVal = 0;
109        for (int x : nums) maxVal = Math.max(maxVal, x);
110        int[] freq = new int[maxVal + 1];
111        int distinct = 0, l = 0;
112        long ans = 0;
113        for (int r = 0; r < n; r++) {
114            int x = nums[r];
115            if (++freq[x] == 1) distinct++;
116            while (distinct > K) {
117                int y = nums[l++];
118                if (--freq[y] == 0) distinct--;
119            }
120            ans += (r - l + 1L);
121        }
122        return ans;
123    }
124
125    static class Precomp {
126        int maxVal;
127        int[][] pos; // pos[v] = all occurrence indices of value v
128
129        Precomp(int[] nums) {
130            int n = nums.length;
131            maxVal = 0;
132            for (int x : nums) maxVal = Math.max(maxVal, x);
133
134            int[] cnt = new int[maxVal + 1];
135            for (int x : nums) cnt[x]++;
136
137            pos = new int[maxVal + 1][];
138            for (int v = 0; v <= maxVal; v++) {
139                if (cnt[v] > 0) pos[v] = new int[cnt[v]];
140            }
141
142            int[] fill = new int[maxVal + 1];
143            for (int i = 0; i < n; i++) {
144                int x = nums[i];
145                pos[x][fill[x]++] = i;
146            }
147        }
148    }
149
150    private long atMostKM(int[] nums, int K, int m, Precomp pc) {
151        if (K <= 0) return 0;
152        int n = nums.length;
153
154        SegTree seg = new SegTree(n);
155
156        int[] occPtr = new int[pc.maxVal + 1];     // how many occurrences processed so far
157        int[] curL = new int[pc.maxVal + 1];       // current forbidden interval L per value
158        int[] curR = new int[pc.maxVal + 1];       // current forbidden interval R per value
159        Arrays.fill(curR, -1);
160
161        int[] win = new int[pc.maxVal + 1];        // window freq for distinct<=K
162        int distinct = 0;
163        int leftK = 0;
164
165        long ans = 0;
166
167        for (int r = 0; r < n; r++) {
168            int x = nums[r];
169
170            // Update forbidden interval for x (remove old, add new)
171            int oldR = curR[x];
172            if (oldR != -1) seg.add(curL[x], oldR, -1);
173
174            int c = ++occPtr[x];
175            int newL = (c < m) ? 0 : pc.pos[x][c - m] + 1; // forbidden [newL..r]
176            seg.add(newL, r, +1);
177
178            curL[x] = newL;
179            curR[x] = r;
180
181            // Maintain at most K distinct window starts (leftK)
182            if (++win[x] == 1) distinct++;
183            while (distinct > K) {
184                int y = nums[leftK++];
185                if (--win[y] == 0) distinct--;
186            }
187
188            // Count valid starts in [leftK..r] where forbidden coverage == 0
189            ans += seg.zerosCount(leftK, r);
190        }
191
192        return ans;
193    }
194}
195