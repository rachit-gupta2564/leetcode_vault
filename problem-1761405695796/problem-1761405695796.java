// Last updated: 25/10/2025, 20:51:35
class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += Math.abs((long)nums2[i] - nums1[i]);
        }
        long extra = Long.MAX_VALUE;
        long t = nums2[n];
        for (int i = 0; i < n; i++) {
            long a = nums1[i], b = nums2[i];
            long f1 = Math.abs(b - a) + Math.abs(t - a);
            long f2 = Math.abs(a - b) + Math.abs(t - b);
            long f3 = Math.abs(a - t) + Math.abs(b - t);
            long bestHere = Math.min(f1, Math.min(f2, f3));
            long change = bestHere - Math.abs(b - a);
            if (change < extra) extra = change;
        }
        return s + extra + 1;
    }
}
