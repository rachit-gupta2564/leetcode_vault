// Last updated: 19/10/2025, 08:27:29
import java.util.*;
class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int m = k;
        for (int x : nums) {
            if (x < m) {
                continue;
            }
            if (x % k != 0) {
                continue;
            }
            if (x == m) {
                m += k;
            }
            else if (x > m) {
                break;
            }
        }
        return m;
    }
}