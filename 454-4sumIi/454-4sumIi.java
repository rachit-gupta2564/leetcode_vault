// Last updated: 22/09/2025, 16:17:03
import java.util.*;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Store all possible sums of nums1[i] + nums2[j] in a map
        for (int a : nums1) {
            for (int b : nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        
        int count = 0;
        // Check for complementary sums from nums3 and nums4
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                count += map.getOrDefault(target, 0);
            }
        }
        
        return count;
    }
}
