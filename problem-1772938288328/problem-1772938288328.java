// Last updated: 08/03/2026, 08:21:28
1class Solution {
2    public int minimumIndex(int[] capacity, int itemSize) {
3        int ans = Integer.MAX_VALUE;
4        int idx = -1;
5        for (int i = 0; i < capacity.length; i ++) {
6            if (capacity[i] >= itemSize) {
7                if (capacity[i] < ans) {
8                    ans = capacity[i];
9                    idx = i;
10                }
11            }
12        }
13        return idx;
14    }
15}