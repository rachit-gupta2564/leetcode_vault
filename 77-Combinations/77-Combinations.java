// Last updated: 16/09/2025, 22:52:41
import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) return res;
        int[] comb = new int[k];
        for (int i = 0; i < k; i++) comb[i] = i + 1;
        while (true) {
            List<Integer> cur = new ArrayList<>(k);
            for (int v : comb) cur.add(v);
            res.add(cur);
            int i = k - 1;
            while (i >= 0 && comb[i] == n - k + i + 1) i--;
            if (i < 0) break;
            comb[i]++;
            for (int j = i + 1; j < k; j++) comb[j] = comb[j - 1] + 1;
        }
        return res;
    }
}
