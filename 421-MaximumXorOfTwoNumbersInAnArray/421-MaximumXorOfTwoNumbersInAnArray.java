// Last updated: 22/09/2025, 16:17:35
import java.util.*;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int k = 31; k >= 0; k--) {
            mask |= (1 << k);
            Set<Integer> prefixes = new HashSet<>();
            for (int v : nums) prefixes.add(v & mask);
            int candidate = max | (1 << k);
            boolean found = false;
            for (int p : prefixes) {
                if (prefixes.contains(p ^ candidate)) {
                    found = true;
                    break;
                }
            }
            if (found) max = candidate;
        }
        return max;
    }
}
