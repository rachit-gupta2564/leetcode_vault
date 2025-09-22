// Last updated: 22/09/2025, 16:18:40
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        int lo = 1, hi = num / 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long sq = (long) mid * mid;
            if (sq == num) return true;
            if (sq < num) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
