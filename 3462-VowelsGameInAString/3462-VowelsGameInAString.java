// Last updated: 13/09/2025, 13:41:02
class Solution {
    public boolean doesAliceWin(String s) {
        String v = "aeiou";
        for (int i = 0; i < s.length(); i++) {
            if (v.indexOf(s.charAt(i)) != -1) return true;
        }
        return false;
    }
}
