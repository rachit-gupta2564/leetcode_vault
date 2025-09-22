// Last updated: 22/09/2025, 16:15:18
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        java.util.List<int[]> a = new java.util.ArrayList<>();
        java.util.List<int[]> b = new java.util.ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (img1[i][j] == 1) a.add(new int[]{i, j});
                if (img2[i][j] == 1) b.add(new int[]{i, j});
            }
        }
        if (a.isEmpty() || b.isEmpty()) return 0;
        java.util.Map<String, Integer> map = new java.util.HashMap<>();
        int ans = 0;
        for (int[] p : a) {
            for (int[] q : b) {
                int dx = q[0] - p[0];
                int dy = q[1] - p[1];
                String key = dx + "," + dy;
                int val = map.getOrDefault(key, 0) + 1;
                map.put(key, val);
                if (val > ans) ans = val;
            }
        }
        return ans;
    }
}
