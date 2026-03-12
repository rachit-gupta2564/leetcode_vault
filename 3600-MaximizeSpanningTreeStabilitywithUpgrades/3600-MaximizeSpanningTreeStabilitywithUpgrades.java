// Last updated: 12/03/2026, 21:16:08
1class Solution {
2    private int n, k;
3    private int[][] edges;
4
5    private int[] baseParent;
6    private int[] baseRank;
7    private int baseComponents;
8
9    private boolean hasMust = false;
10    private int minMustStrength = Integer.MAX_VALUE;
11
12    public int maxStability(int n, int[][] edges, int k) {
13        this.n = n;
14        this.edges = edges;
15        this.k = k;
16
17        baseParent = new int[n];
18        baseRank = new int[n];
19        for (int i = 0; i < n; i++) baseParent[i] = i;
20
21        baseComponents = n;
22        int hi = 0;
23
24        // Build mandatory forest once
25        for (int[] e : edges) {
26            int u = e[0], v = e[1], s = e[2], must = e[3];
27            hi = Math.max(hi, 2 * s);
28
29            if (must == 1) {
30                hasMust = true;
31                minMustStrength = Math.min(minMustStrength, s);
32
33                if (!union(baseParent, baseRank, u, v)) {
34                    return -1; // mandatory edges form a cycle
35                }
36                baseComponents--;
37            }
38        }
39
40        int lo = 1, ans = -1;
41
42        while (lo <= hi) {
43            int mid = lo + (hi - lo) / 2;
44            if (can(mid)) {
45                ans = mid;
46                lo = mid + 1;
47            } else {
48                hi = mid - 1;
49            }
50        }
51
52        return ans;
53    }
54
55    private boolean can(int target) {
56        if (hasMust && target > minMustStrength) return false;
57
58        int[] parent = baseParent.clone();
59        int[] rank = baseRank.clone();
60        int components = baseComponents;
61
62        // 0-cost edges: already strong enough
63        for (int[] e : edges) {
64            int u = e[0], v = e[1], s = e[2], must = e[3];
65            if (must == 0 && s >= target) {
66                if (union(parent, rank, u, v)) {
67                    components--;
68                }
69            }
70        }
71
72        // 1-cost edges: need one upgrade
73        int usedUpgrades = 0;
74        for (int[] e : edges) {
75            int u = e[0], v = e[1], s = e[2], must = e[3];
76            if (must == 0 && s < target && 2 * s >= target) {
77                if (union(parent, rank, u, v)) {
78                    components--;
79                    usedUpgrades++;
80                    if (usedUpgrades > k) return false;
81                }
82            }
83        }
84
85        return components == 1;
86    }
87
88    private int find(int[] parent, int x) {
89        if (parent[x] != x) {
90            parent[x] = find(parent, parent[x]);
91        }
92        return parent[x];
93    }
94
95    private boolean union(int[] parent, int[] rank, int a, int b) {
96        int pa = find(parent, a);
97        int pb = find(parent, b);
98
99        if (pa == pb) return false;
100
101        if (rank[pa] < rank[pb]) {
102            parent[pa] = pb;
103        } else if (rank[pa] > rank[pb]) {
104            parent[pb] = pa;
105        } else {
106            parent[pb] = pa;
107            rank[pa]++;
108        }
109        return true;
110    }
111}
112