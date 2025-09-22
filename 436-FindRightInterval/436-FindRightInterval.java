// Last updated: 22/09/2025, 16:17:26
import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];
            int idx = binarySearch(starts, target);
            res[i] = idx == -1 ? -1 : starts[idx][1];
        }
        return res;
    }
    
    private int binarySearch(int[][] starts, int target) {
        int l = 0, r = starts.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (starts[m][0] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
