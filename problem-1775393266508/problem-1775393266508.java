// Last updated: 05/04/2026, 18:17:46
1class Solution {
2    public boolean judgeCircle(String moves) {
3        int x = 0, y = 0;
4
5        for (char ch : moves.toCharArray()) {
6            if (ch == 'U') y++;
7            else if (ch == 'D') y--;
8            else if (ch == 'L') x--;
9            else if (ch == 'R') x++;
10        }
11
12        return x == 0 && y == 0;
13    }
14}