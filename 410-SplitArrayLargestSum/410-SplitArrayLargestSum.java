// Last updated: 22/09/2025, 16:17:48
class Solution {
    public int splitArray(int[] nums, int k) {
        long lo = 0, hi = 0;
        for (int v : nums) {
            lo = Math.max(lo, v);
            hi += v;
        }
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (requiredParts(nums, mid) <= k) hi = mid;
            else lo = mid + 1;
        }
        return (int) lo;
    }
    
    private int requiredParts(int[] nums, long maxSum) {
        int parts = 1;
        long cur = 0;
        for (int v : nums) {
            if (cur + v > maxSum) {
                parts++;
                cur = v;
            } else {
                cur += v;
            }
        }
        return parts;
    }
}
