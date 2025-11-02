// Last updated: 02/11/2025, 23:39:16
class Solution {
    public String lexSmallest(String s) {
        char[] arr = s.toCharArray();
        String best = s;
        int n = arr.length;
        for (int k = 1; k <= n; k++) {
            char[] first = new char[n];
            for (int i = 0, j = k - 1; i < k; i++, j--) {
                first[i] = arr[j];
            }
            for (int i = k; i < n; i++) {
                first[i] = arr[i];
            }
            String s1 = new String(first);
            if (s1.compareTo(best) < 0) {
                best = s1;
            }
            char[] last = new char[n];
            for (int i = n - k, j = n - 1; j >= n - k; i++, j--) {
                last[i] = arr[j];
            }
            for (int i = 0; i < n - k; i++) {
                last[i] = arr[i];
            }
            String s2 = new String(last);
            if (s2.compareTo(best) < 0) {
                best = s2;
            }
        }
        return best;
    }
}