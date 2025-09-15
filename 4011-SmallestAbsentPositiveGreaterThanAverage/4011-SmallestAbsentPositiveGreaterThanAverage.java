// Last updated: 15/09/2025, 22:05:03
import java.util.*;
class Solution {
    public int smallestAbsent(int[] nums) {
        int n = nums.length ,s = 0;
        for(int x : nums) {
            s += x;
        }
        double av = s/(double)n;
        int st = Math.max(1, (int)Math.floor(av) + 1);
        HashSet<Integer> h = new HashSet<>();
        for(int x : nums) {
            h.add(x);
        }
        for(int k = st;;k++) {
            if(!h.contains(k)) {
                return k;
            }
        }
    }
}