// Last updated: 15/09/2025, 22:05:05
import java.util.*;
class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        TreeSet<Integer> t = new TreeSet<>(Collections.reverseOrder());
        for (int x : nums)
            {
                t.add(x);
            }
        int[] n = Arrays.copyOf(nums, nums.length);
        int m = Math.min(k, t.size());
        int[] s = new int[m];
        int i = 0;
        for (int v : t)
            {
                if (i == m)
                {
                    break;
                }
                s[i ++] = v;
            }
        return s;
    }
}