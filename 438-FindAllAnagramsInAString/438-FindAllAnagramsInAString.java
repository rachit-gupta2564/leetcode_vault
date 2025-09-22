// Last updated: 22/09/2025, 16:17:23
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] countP = new int[26];
        int[] countS = new int[26];
        for (char c : p.toCharArray()) countP[c - 'a']++;
        char[] arrS = s.toCharArray();
        int len = p.length();
        for (int i = 0; i < arrS.length; i++) {
            countS[arrS[i] - 'a']++;
            if (i >= len) countS[arrS[i - len] - 'a']--;
            if (Arrays.equals(countS, countP)) res.add(i - len + 1);
        }
        return res;
    }
}
