// Last updated: 22/09/2025, 16:15:30
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }
    
    private int count(int[] nums, int bound) {
        int res = 0, length = 0;
        for (int num : nums) {
            if (num <= bound) {
                length++;
                res += length;
            } else {
                length = 0;
            }
        }
        return res;
    }
}
