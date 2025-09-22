// Last updated: 22/09/2025, 16:17:33
class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int left = 0, maxCount = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            maxCount = Math.max(maxCount, ++cnt[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                cnt[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
