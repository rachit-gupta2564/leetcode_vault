// Last updated: 22/09/2025, 16:18:18
import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        int curr = 1;
        for (int i = 0; i < n; i++) {
            res.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                if (curr >= n) curr /= 10;
                curr++;
                while (curr % 10 == 0) curr /= 10;
            }
        }
        return res;
    }
}
