// Last updated: 16/02/2026, 10:44:04
1class Solution {
2    // Reverse bits of a 32-bit unsigned integer
3    public int reverseBits(int n) {
4        int result = 0;
5        for (int i = 0; i < 32; i++) {
6            result <<= 1;          // shift result left to make room
7            result |= (n & 1);     // copy the least significant bit of n
8            n >>= 1;               // shift n right to process next bit
9        }
10        return result;
11    }
12}