// Last updated: 19/02/2026, 13:10:33
1class Solution {
2    public int countBinarySubstrings(String s) {
3        int n = s.length();
4        int prevGroup = 0;  // length of previous run
5        int currGroup = 1;  // length of current run (at least 1)
6        int ans = 0;
7
8        for (int i = 1; i < n; i++) {
9            if (s.charAt(i) == s.charAt(i - 1)) {
10                currGroup++;
11            } else {
12                ans += Math.min(prevGroup, currGroup);
13                prevGroup = currGroup;
14                currGroup = 1;
15            }
16        }
17
18        ans += Math.min(prevGroup, currGroup); // last boundary
19        return ans;
20    }
21}
22