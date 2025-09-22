// Last updated: 22/09/2025, 16:18:35
import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) return res;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        int n1 = Math.min(nums1.length, k);
        for (int i = 0; i < n1; i++) {
            pq.offer(new long[]{(long)nums1[i] + nums2[0], i, 0});
        }
        while (!pq.isEmpty() && res.size() < k) {
            long[] cur = pq.poll();
            int i = (int) cur[1];
            int j = (int) cur[2];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                pq.offer(new long[]{(long)nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return res;
    }
}
