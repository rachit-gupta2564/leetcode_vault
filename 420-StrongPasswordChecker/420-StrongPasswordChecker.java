// Last updated: 22/09/2025, 16:17:37
import java.util.*;

class Solution {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
        }
        int missing = 0;
        if (!hasLower) missing++;
        if (!hasUpper) missing++;
        if (!hasDigit) missing++;

        List<Integer> runs = new ArrayList<>();
        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            int len = j - i;
            if (len >= 3) runs.add(len);
            i = j;
        }

        if (n < 6) {
            return Math.max(missing, 6 - n);
        } else if (n <= 20) {
            int replace = 0;
            for (int len : runs) replace += len / 3;
            return Math.max(missing, replace);
        } else {
            int toDelete = n - 20;
            // first try to reduce runs where len%3==0, then len%3==1, then len%3==2
            for (int mod = 0; mod < 3 && toDelete > 0; mod++) {
                for (int i = 0; i < runs.size() && toDelete > 0; i++) {
                    int len = runs.get(i);
                    if (len < 3 || len % 3 != mod) continue;
                    int del = Math.min(toDelete, mod + 1);
                    runs.set(i, len - del);
                    toDelete -= del;
                }
            }
            // if deletions remain, apply them to largest runs
            if (toDelete > 0) {
                // sort descending by length
                Collections.sort(runs, Collections.reverseOrder());
                for (int i = 0; i < runs.size() && toDelete > 0; i++) {
                    int len = runs.get(i);
                    if (len < 3) continue;
                    int can = Math.min(toDelete, len - 2); // keep at least 2 to stop being a run
                    runs.set(i, len - can);
                    toDelete -= can;
                }
            }
            int replace = 0;
            for (int len : runs) if (len >= 3) replace += len / 3;
            return (n - 20) + Math.max(missing, replace);
        }
    }
}
