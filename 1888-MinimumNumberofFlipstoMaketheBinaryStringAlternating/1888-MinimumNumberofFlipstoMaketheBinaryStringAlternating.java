// Last updated: 07/03/2026, 22:50:35
1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        String t = s + s;
5
6        int diff1 = 0; // mismatches with pattern 010101...
7        int diff2 = 0; // mismatches with pattern 101010...
8        int ans = Integer.MAX_VALUE;
9
10        for (int i = 0; i < t.length(); i++) {
11            char ch = t.charAt(i);
12
13            char p1 = (i % 2 == 0) ? '0' : '1';
14            char p2 = (i % 2 == 0) ? '1' : '0';
15
16            if (ch != p1) diff1++;
17            if (ch != p2) diff2++;
18
19            if (i >= n) {
20                char left = t.charAt(i - n);
21
22                char oldP1 = ((i - n) % 2 == 0) ? '0' : '1';
23                char oldP2 = ((i - n) % 2 == 0) ? '1' : '0';
24
25                if (left != oldP1) diff1--;
26                if (left != oldP2) diff2--;
27            }
28
29            if (i >= n - 1) {
30                ans = Math.min(ans, Math.min(diff1, diff2));
31            }
32        }
33
34        return ans;
35    }
36}
37