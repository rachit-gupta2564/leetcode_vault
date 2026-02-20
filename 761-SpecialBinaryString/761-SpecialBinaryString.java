// Last updated: 20/02/2026, 16:52:38
1import java.util.*;
2
3class Solution {
4    public String makeLargestSpecial(String s) {
5        List<String> parts = new ArrayList<>();
6        int balance = 0;
7        int start = 0;
8
9        for (int i = 0; i < s.length(); i++) {
10            balance += (s.charAt(i) == '1') ? 1 : -1;
11            if (balance == 0) {
12                String inner = s.substring(start + 1, i);
13                String bestInner = makeLargestSpecial(inner);
14                parts.add("1" + bestInner + "0");
15                start = i + 1;
16            }
17        }
18
19        parts.sort(Collections.reverseOrder());
20
21        StringBuilder sb = new StringBuilder();
22        for (String p : parts) sb.append(p);
23        return sb.toString();
24    }
25}
26