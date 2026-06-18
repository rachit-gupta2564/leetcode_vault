// Last updated: 18/06/2026, 09:41:56
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        HashMap<Character, Integer> map = new HashMap<>();
4        int l = 0, ans = 0;
5        for (int r = 0; r < s.length(); r ++) {
6            char ch = s.charAt(r);
7            map.put(ch, map.getOrDefault(ch, 0) + 1);
8            while (map.get(ch) > 1) {
9                char lch = s.charAt(l);
10                map.put(lch, map.get(lch) - 1);
11                l ++;
12            }
13            ans = Math.max(ans, r - l + 1);
14        }
15        return ans;
16    }
17}