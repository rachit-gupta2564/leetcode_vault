// Last updated: 01/03/2026, 20:06:47
1class Solution {
2    public int minPartitions(String n) {
3        int maxDigit = 0;
4        for (int i = 0; i < n.length(); i++) {
5            int d = n.charAt(i) - '0';
6            if (d > maxDigit) maxDigit = d;
7            if (maxDigit == 9) return 9; // early exit (can't do better than 9)
8        }
9        return maxDigit;
10    }
11}