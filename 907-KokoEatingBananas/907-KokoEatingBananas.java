// Last updated: 22/09/2025, 16:15:00
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int p : piles) maxPile = Math.max(maxPile, p);
        int low = 1, high = maxPile;
        while (low < high) {
            long mid = low + (high - low) / 2; // candidate speed
            long hours = 0;
            for (int p : piles) {
                // compute ceil(p / mid) safely using longs
                hours += (p + mid - 1) / mid;
                if (hours > h) break; // early exit if already too slow
            }
            if (hours <= h) high = (int) mid; // can finish with this speed, try slower
            else low = (int) (mid + 1);       // too slow, need faster
        }
        return low;
    }
}
