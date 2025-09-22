// Last updated: 22/09/2025, 16:16:38
class Solution {
    public int findComplement(int num) {
        int mask = 1;
        int n = num;
        // Create a mask with the same number of bits as num
        while (n > 0) {
            mask <<= 1;
            n >>= 1;
        }
        mask -= 1; // mask with all 1's in the positions of num's bits
        return num ^ mask; // XOR with mask flips all bits
    }
}
