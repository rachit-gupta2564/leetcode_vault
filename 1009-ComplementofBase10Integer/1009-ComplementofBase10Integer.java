// Last updated: 11/03/2026, 20:22:11
1class Solution {
2    public int bitwiseComplement(int n) {
3        if (n == 0) return 1;
4
5        int bitLength = 32 - Integer.numberOfLeadingZeros(n);
6        int mask = (1 << bitLength) - 1;
7
8        return n ^ mask;
9    }
10}