// Last updated: 22/09/2025, 16:16:06
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;

        int left = 0, right = 0, required = len1;
        while (right < len2) {
            if (count[s2.charAt(right) - 'a'] > 0) required--;
            count[s2.charAt(right) - 'a']--;
            right++;

            if (required == 0) return true;

            if (right - left == len1) {
                if (count[s2.charAt(left) - 'a'] >= 0) required++;
                count[s2.charAt(left) - 'a']++;
                left++;
            }
        }
        return false;
    }
}
