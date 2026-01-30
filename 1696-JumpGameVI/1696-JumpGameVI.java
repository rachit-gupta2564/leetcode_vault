// Last updated: 30/01/2026, 13:11:06
1import java.util.*;
2
3class Solution {
4    public int maxResult(int[] nums, int k) {
5        int n = nums.length;
6        int[] dp = new int[n];
7        dp[0] = nums[0];
8
9        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
10        pq.offer(new int[]{dp[0], 0});
11
12        for (int i = 1; i < n; i++) {
13            while (!pq.isEmpty() && pq.peek()[1] < i - k) pq.poll();
14
15            dp[i] = nums[i] + pq.peek()[0];
16
17            pq.offer(new int[]{dp[i], i});
18        }
19        return dp[n - 1];
20    }
21}
22