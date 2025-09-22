// Last updated: 22/09/2025, 16:16:34
import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        TreeMap<Integer, Integer> lo = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, Integer> hi = new TreeMap<>();
        int loSize = 0, hiSize = 0;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (loSize == 0 || num <= lo.firstKey()) {
                lo.put(num, lo.getOrDefault(num, 0) + 1);
                loSize++;
            } else {
                hi.put(num, hi.getOrDefault(num, 0) + 1);
                hiSize++;
            }

            // Balance sizes: lo can have at most 1 more element than hi
            while (loSize > hiSize + 1) {
                int key = lo.firstKey();
                lo.put(key, lo.get(key) - 1);
                if (lo.get(key) == 0) lo.remove(key);
                loSize--;
                hi.put(key, hi.getOrDefault(key, 0) + 1);
                hiSize++;
            }
            while (hiSize > loSize) {
                int key = hi.firstKey();
                hi.put(key, hi.get(key) - 1);
                if (hi.get(key) == 0) hi.remove(key);
                hiSize--;
                lo.put(key, lo.getOrDefault(key, 0) + 1);
                loSize++;
            }

            if (i >= k - 1) {
                // Calculate median
                if ((k & 1) == 0) {
                    result[i - k + 1] = ((double) lo.firstKey() + hi.firstKey()) / 2;
                } else {
                    result[i - k + 1] = (double) lo.firstKey();
                }

                // Remove the element going out of the window
                int out = nums[i - k + 1];
                if (lo.containsKey(out)) {
                    lo.put(out, lo.get(out) - 1);
                    if (lo.get(out) == 0) lo.remove(out);
                    loSize--;
                } else {
                    hi.put(out, hi.get(out) - 1);
                    if (hi.get(out) == 0) hi.remove(out);
                    hiSize--;
                }

                // Re-balance after removal
                while (loSize > hiSize + 1) {
                    int key = lo.firstKey();
                    lo.put(key, lo.get(key) - 1);
                    if (lo.get(key) == 0) lo.remove(key);
                    loSize--;
                    hi.put(key, hi.getOrDefault(key, 0) + 1);
                    hiSize++;
                }
                while (hiSize > loSize) {
                    int key = hi.firstKey();
                    hi.put(key, hi.get(key) - 1);
                    if (hi.get(key) == 0) hi.remove(key);
                    hiSize--;
                    lo.put(key, lo.getOrDefault(key, 0) + 1);
                    loSize++;
                }
            }
        }
        return result;
    }
}
