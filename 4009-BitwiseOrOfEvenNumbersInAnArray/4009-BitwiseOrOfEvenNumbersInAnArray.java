// Last updated: 22/09/2025, 16:13:06
class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int result = 0;
        for (int value : nums) {
            if ((value & 1) == 0) {
                result |= value;
            }
        }
        if (result == 0) {
            for (int n : nums) {
                if (n % 2 == 0) return 0;
            }
        }
        return result;
    }
}