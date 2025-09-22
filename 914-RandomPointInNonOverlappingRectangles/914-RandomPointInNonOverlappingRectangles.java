// Last updated: 22/09/2025, 16:14:57
import java.util.*;

class Solution {
    private int[][] rects;
    private int[] prefixSums;
    private int totalPoints;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSums = new int[rects.length];
        this.totalPoints = 0;
        this.rand = new Random();
        
        for (int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            int points = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            totalPoints += points;
            prefixSums[i] = totalPoints;
        }
    }
    
    public int[] pick() {
        int k = rand.nextInt(totalPoints);
        // binary search to find which rectangle k belongs to
        int rectIndex = Arrays.binarySearch(prefixSums, k + 1);
        if (rectIndex < 0) {
            rectIndex = -rectIndex - 1;
        }
        
        int[] r = rects[rectIndex];
        int x = r[0] + rand.nextInt(r[2] - r[0] + 1);
        int y = r[1] + rand.nextInt(r[3] - r[1] + 1);
        return new int[]{x, y};
    }
}
