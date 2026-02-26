// Last updated: 26/02/2026, 18:49:18
1class Solution {
2    public int numSteps(String s) {
3        if (s.equals("1")) return 0;
4
5        int steps = 0;
6        int carry = 0; // 0 or 1
7
8        // Process from LSB to just after MSB (i > 0)
9        for (int i = s.length() - 1; i > 0; i--) {
10            int bit = s.charAt(i) - '0';
11            int v = bit + carry;
12
13            if (v == 0) {          // even
14                steps += 1;        // divide by 2
15            } else if (v == 1) {   // odd
16                steps += 2;        // add 1, then divide by 2
17                carry = 1;
18            } else {               // v == 2, even
19                steps += 1;        // divide by 2
20                carry = 1;         // carry stays
21            }
22        }
23
24        // If carry remains at the MSB, we need one extra division (e.g., 1... + carry => 10...)
25        return steps + carry;
26    }
27}