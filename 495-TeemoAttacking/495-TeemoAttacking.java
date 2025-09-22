// Last updated: 22/09/2025, 16:16:18
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) return 0;

        int total = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            total += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        total += duration; // add duration for the last attack
        return total;
    }
}
