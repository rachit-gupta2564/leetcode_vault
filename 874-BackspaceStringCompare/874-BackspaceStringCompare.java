// Last updated: 22/09/2025, 16:15:14
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            int skip = 0;
            while (i >= 0) {
                if (s.charAt(i) == '#') { skip++; i--; }
                else if (skip > 0) { skip--; i--; }
                else break;
            }
            int skip2 = 0;
            while (j >= 0) {
                if (t.charAt(j) == '#') { skip2++; j--; }
                else if (skip2 > 0) { skip2--; j--; }
                else break;
            }
            char cs = i >= 0 ? s.charAt(i) : '\0';
            char ct = j >= 0 ? t.charAt(j) : '\0';
            if (cs != ct) return false;
            i--; j--;
        }
        return true;
    }
}
