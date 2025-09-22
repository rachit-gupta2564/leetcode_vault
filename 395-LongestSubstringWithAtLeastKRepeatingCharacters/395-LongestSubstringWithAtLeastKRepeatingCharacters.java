// Last updated: 22/09/2025, 16:18:06
class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || k > s.length()) return 0;
        if (k <= 1) return s.length();

        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i + 1), k);
                return Math.max(left, right);
            }
        }
        return s.length();
    }
}
