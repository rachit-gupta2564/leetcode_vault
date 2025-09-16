// Last updated: 16/09/2025, 23:14:56
import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        long[] val = new long[n];
        for (int i = 0; i < n; i++) val[i] = nums[i];
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1 < n ? i + 1 : n;
            alive[i] = true;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i + 1 < n; i++) if (gcd(val[i], val[i + 1]) > 1) q.add(i);
        while (!q.isEmpty()) {
            int i = q.pollFirst();
            if (i < 0 || i >= n || !alive[i]) continue;
            int j = next[i];
            if (j == n || !alive[j]) continue;
            long g = gcd(val[i], val[j]);
            if (g == 1) continue;
            long newVal = val[i] / g * val[j];
            val[i] = newVal;
            alive[j] = false;
            int k = next[j];
            next[i] = k;
            if (k < n) prev[k] = i;
            int p = prev[i];
            if (p >= 0 && alive[p] && gcd(val[p], val[i]) > 1) q.add(p);
            if (next[i] < n && alive[next[i]] && gcd(val[i], val[next[i]]) > 1) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        while (idx < n && !alive[idx]) idx++;
        while (idx < n) {
            ans.add((int)val[idx]);
            idx = next[idx];
            while (idx < n && idx >=0 && !alive[idx]) idx = next[idx];
        }
        return ans;
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
