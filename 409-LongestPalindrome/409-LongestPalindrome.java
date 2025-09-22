// Last updated: 22/09/2025, 16:17:50
class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for (char c : s.toCharArray()) cnt[c]++;
        int len = 0;
        for (int v : cnt) {
            len += (v / 2) * 2;
            if (len % 2 == 0 && v % 2 == 1) len++;
        }
        return len;
    }
}
