// Last updated: 22/09/2025, 16:18:47
import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]); // descending heights for equal widths
        });
        int n = envelopes.length;
        int[] tails = new int[n];
        int size = 0;
        for (int[] env : envelopes) {
            int h = env[1];
            int l = 0, r = size;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (tails[mid] < h) l = mid + 1;
                else r = mid;
            }
            tails[l] = h;
            if (l == size) size++;
        }
        return size;
    }
}
