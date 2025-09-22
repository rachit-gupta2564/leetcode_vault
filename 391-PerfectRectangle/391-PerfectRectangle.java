// Last updated: 22/09/2025, 16:18:11
import java.util.*;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        long area = 0;
        Set<String> set = new HashSet<>();

        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            area += (long)(x2 - x1) * (y2 - y1);

            String[] corners = {x1 + "," + y1, x1 + "," + y2, x2 + "," + y1, x2 + "," + y2};
            for (String c : corners) {
                if (!set.add(c)) set.remove(c);
            }
        }

        if (set.size() != 4) return false;
        return set.contains(minX + "," + minY) && set.contains(minX + "," + maxY)
            && set.contains(maxX + "," + minY) && set.contains(maxX + "," + maxY)
            && area == (long)(maxX - minX) * (maxY - minY);
    }
}
