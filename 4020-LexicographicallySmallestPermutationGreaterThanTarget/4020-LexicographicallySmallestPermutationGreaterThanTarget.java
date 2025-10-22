// Last updated: 22/10/2025, 19:38:54
import java.util.*;
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        char[] t = target.toCharArray();
        char[] pref = new char[n];
        int[] up = new int[n];
        Arrays.fill(up, -1);
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int base = t[i] - 'a';
            int nxt = -1;
            for (int c = base + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    nxt = c;
                    break;
                }
            }
            up[i] = nxt;
            if (cnt[base] > 0) {
                pref[i] = (char)('a' + base);
                cnt[base]--;
                if (nxt != -1) {
                    st.push(i);
                }
            }
            else {
                if (nxt != -1) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < i; k++) {
                        sb.append(pref[k]);
                    }
                    sb.append((char)('a' + nxt));
                    cnt[nxt]--;
                    for (int c = 0; c < 26; c++) {
                        while (cnt[c]-- > 0) {
                            sb.append((char)('a' + c));
                        }
                    }
                    return sb.toString();
                }
                while (!st.isEmpty()) {
                    int j = st.pop();
                    for (int k = j; k < i; k++) {
                        cnt[pref[k] - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < j; k++) {
                        sb.append(pref[k]);
                    }
                    int c = up[j];
                    sb.append((char)('a' + c));
                    cnt[c]--;
                    for (int cc = 0; cc < 26; cc++) {
                        while (cnt[cc]-- > 0) {
                            sb.append((char)('a' + cc));
                        }
                    }
                    return sb.toString();
                }
                return "";
            }
        }
        if (!st.isEmpty()) {
            int j = st.pop();
            for (int k = j; k < n; k++) {
                cnt[pref[k] - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < j; k++) {
                sb.append(pref[k]);
            }
            int c = up[j];
            sb.append((char)('a' + c));
            cnt[c]--;
            for (int cc = 0; cc < 26; cc++) {
                while (cnt[cc]-- > 0) {
                    sb.append((char)('a' + cc));
                }
            }
            return sb.toString();
        }
        return "";
    }
}