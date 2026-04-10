// Last updated: 11/04/2026, 00:14:11
1import java.util.*;
2
3class Solution {
4    public int minimumDistance(int[] nums) {
5        Map<Integer, List<Integer>> map = new HashMap<>();
6        
7        for (int i = 0; i < nums.length; i++) {
8            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
9        }
10        
11        int ans = Integer.MAX_VALUE;
12        
13        for (List<Integer> pos : map.values()) {
14            for (int i = 2; i < pos.size(); i++) {
15                ans = Math.min(ans, 2 * (pos.get(i) - pos.get(i - 2)));
16            }
17        }
18        
19        return ans == Integer.MAX_VALUE ? -1 : ans;
20    }
21}