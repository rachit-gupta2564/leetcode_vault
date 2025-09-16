// Last updated: 16/09/2025, 22:54:16
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = 1 << n;
        List<List<Integer>> res = new ArrayList<>(total);
        for (int mask = 0; mask < total; mask++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < n; j++) if ((mask & (1 << j)) != 0) cur.add(nums[j]);
            res.add(cur);
        }
        return res;
    }
}
