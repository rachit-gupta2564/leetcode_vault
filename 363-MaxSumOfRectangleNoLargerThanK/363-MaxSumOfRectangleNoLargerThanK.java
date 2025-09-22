// Last updated: 22/09/2025, 16:18:43
import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        if (m <= n) {
            for (int top = 0; top < m; top++) {
                int[] colSums = new int[n];
                for (int bottom = top; bottom < m; bottom++) {
                    for (int c = 0; c < n; c++) colSums[c] += matrix[bottom][c];
                    result = Math.max(result, maxSubArrayNoMoreThanK(colSums, k));
                    if (result == k) return k;
                }
            }
        } else {
            for (int left = 0; left < n; left++) {
                int[] rowSums = new int[m];
                for (int right = left; right < n; right++) {
                    for (int r = 0; r < m; r++) rowSums[r] += matrix[r][right];
                    result = Math.max(result, maxSubArrayNoMoreThanK(rowSums, k));
                    if (result == k) return k;
                }
            }
        }
        return result;
    }

    private int maxSubArrayNoMoreThanK(int[] arr, int k) {
        TreeSet<Integer> prefixes = new TreeSet<>();
        prefixes.add(0);
        int sum = 0;
        int best = Integer.MIN_VALUE;
        for (int v : arr) {
            sum += v;
            Integer target = prefixes.ceiling(sum - k);
            if (target != null) best = Math.max(best, sum - target);
            prefixes.add(sum);
        }
        return best;
    }
}
