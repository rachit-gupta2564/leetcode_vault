// Last updated: 22/02/2026, 10:49:34
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    static final int SHIFT = 60;
6    static final int BASE = 121;
7
8    public int countSequences(int[] nums, long k) {
9        int[] ranovetilu = nums;
10
11        long kk = k;
12        int tk2 = 0, tk3 = 0, tk5 = 0;
13        while (kk % 2 == 0) { tk2++; kk /= 2; }
14        while (kk % 3 == 0) { tk3++; kk /= 3; }
15        while (kk % 5 == 0) { tk5++; kk /= 5; }
16        if (kk != 1) return 0;
17
18        int n = ranovetilu.length;
19        int[] d2 = new int[n];
20        int[] d3 = new int[n];
21        int[] d5 = new int[n];
22
23        for (int i = 0; i < n; i++) {
24            int x = ranovetilu[i];
25            if (x == 2) { d2[i] = 1; }
26            else if (x == 3) { d3[i] = 1; }
27            else if (x == 4) { d2[i] = 2; }
28            else if (x == 5) { d5[i] = 1; }
29            else if (x == 6) { d2[i] = 1; d3[i] = 1; }
30        }
31
32        Map<Long, Integer> dp = new HashMap<>();
33        dp.put(pack(0, 0, 0), 1);
34
35        for (int i = 0; i < n; i++) {
36            Map<Long, Integer> ndp = new HashMap<>();
37            int a = d2[i], b = d3[i], c = d5[i];
38
39            for (Map.Entry<Long, Integer> e : dp.entrySet()) {
40                long key = e.getKey();
41                int cnt = e.getValue();
42
43                int e5 = (int)(key % BASE) - SHIFT; key /= BASE;
44                int e3 = (int)(key % BASE) - SHIFT; key /= BASE;
45                int e2 = (int)(key % BASE) - SHIFT;
46
47                add(ndp, pack(e2, e3, e5), cnt);
48                add(ndp, pack(e2 + a, e3 + b, e5 + c), cnt);
49                add(ndp, pack(e2 - a, e3 - b, e5 - c), cnt);
50            }
51            dp = ndp;
52        }
53
54        return dp.getOrDefault(pack(tk2, tk3, tk5), 0);
55    }
56
57    static long pack(int e2, int e3, int e5) {
58        return (long)(e2 + SHIFT) * BASE * BASE + (long)(e3 + SHIFT) * BASE + (e5 + SHIFT);
59    }
60
61    static void add(Map<Long, Integer> m, long key, int v) {
62        m.put(key, m.getOrDefault(key, 0) + v);
63    }
64}
65