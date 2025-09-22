// Last updated: 22/09/2025, 16:15:01
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        java.util.Map<Integer, Integer> index = new java.util.HashMap<>();
        for (int i = 0; i < n; ++i) index.put(arr[i], i);

        int[][] dp = new int[n][n];
        // default length for any pair is 2 (the two elements themselves)
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) dp[i][j] = 2;
        }

        int best = 0;
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < j; ++i) {
                int need = arr[j] - arr[i];
                Integer k = index.get(need);
                // need must be strictly less than arr[i] to keep increasing indices (and values)
                if (k != null && k < i) {
                    dp[i][j] = dp[k][i] + 1;
                    best = Math.max(best, dp[i][j]);
                }
                // otherwise dp[i][j] stays 2
            }
        }
        return best >= 3 ? best : 0;
    }
}
