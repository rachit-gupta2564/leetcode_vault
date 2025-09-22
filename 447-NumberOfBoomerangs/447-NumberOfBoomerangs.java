// Last updated: 22/09/2025, 16:17:14
import java.util.*;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, res = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int dist = dx * dx + dy * dy;
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int count : map.values()) {
                res += count * (count - 1);
            }
        }
        return res;
    }
}
