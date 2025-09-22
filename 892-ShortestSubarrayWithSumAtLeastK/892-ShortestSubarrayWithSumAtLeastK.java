// Last updated: 22/09/2025, 16:15:05
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) prefix[i + 1] = prefix[i] + nums[i];

        java.util.ArrayDeque<Integer> dq = new java.util.ArrayDeque<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; ++i) {
            // If current prefix minus the smallest prefix in deque >= k,
            // we can update answer and pop that smallest prefix (greedy shortest).
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                ans = Math.min(ans, i - dq.removeFirst());
            }
            // Maintain deque increasing by prefix sum: remove worse (larger or equal) tails.
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
