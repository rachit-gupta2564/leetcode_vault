// Last updated: 22/09/2025, 16:16:36
class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;
        
        // Consider each of the 32 bits
        for (int bit = 0; bit < 32; bit++) {
            int countOnes = 0;
            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    countOnes++;
                }
            }
            int countZeros = n - countOnes;
            total += countOnes * countZeros; // Each 1-0 pair contributes 1 to Hamming distance
        }
        
        return total;
    }
}
