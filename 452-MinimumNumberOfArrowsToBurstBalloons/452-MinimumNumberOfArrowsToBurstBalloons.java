// Last updated: 22/09/2025, 16:17:06
import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        
        // Sort balloons by their ending x-coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1; // At least one arrow needed
        int end = points[0][1]; // Position of the first arrow
        
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the last arrow's position,
            // we need a new arrow
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1]; // Shoot new arrow at this balloon's end
            }
            // Otherwise, current arrow can burst this balloon, do nothing
        }
        
        return arrows;
    }
}
