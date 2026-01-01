// Last updated: 01/01/2026, 18:33:08
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) total += b;
        long left = 0, right = total / n;
        while (left < right) {
            long mid = right - (right - left) / 2;
            long curr = 0;
            for (int b : batteries) curr += Math.min(b, mid);
            if (curr >= mid * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
