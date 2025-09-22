// Last updated: 22/09/2025, 16:19:35
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int k = primes.length;
        int[] idx = new int[k];
        long[] next = new long[k];
        for (int i = 0; i < k; i++) next[i] = primes[i];

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) min = Math.min(min, next[j]);
            ugly[i] = (int) min;
            for (int j = 0; j < k; j++) {
                if (next[j] == min) next[j] = (long) ugly[++idx[j]] * primes[j];
            }
        }
        return ugly[n - 1];
    }
}
