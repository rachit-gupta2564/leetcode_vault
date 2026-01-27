// Last updated: 27/01/2026, 17:35:12
1class Solution {
2    public int closestMeetingNode(int[] edges, int node1, int node2) {
3        int n = edges.length;
4        Map<Integer, Integer> map = new HashMap<>();
5        int cur = node1, step = 0;
6        while (cur != -1 && !map.containsKey(cur)) {
7            map.put(cur, step ++);
8            cur = edges[cur];
9        }
10        int ans = -1;
11        int best = Integer.MAX_VALUE;
12        cur = node2;
13        step = 0;
14        Set<Integer> seen = new HashSet<>();
15        while (cur != -1 && !seen.contains(cur)) {
16            seen.add(cur);
17            Integer a = map.get(cur);
18            if (a != null) {
19                int val = Math.max(a, step);
20                if (val < best || (val == best && cur < ans)) {
21                    best = val;
22                    ans = cur;
23                }
24            }
25            step ++;
26            cur = edges[cur];
27        }
28        return ans;
29    }
30}