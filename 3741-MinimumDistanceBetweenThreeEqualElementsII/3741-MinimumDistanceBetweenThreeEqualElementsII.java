// Last updated: 11/04/2026, 21:41:50
1import java.util.Arrays;
2
3class Solution {
4    public int minimumDistance(int[] nums) {
5        int n = nums.length;
6        int[] last = new int[n + 1];      // most recent index
7        int[] secondLast = new int[n + 1]; // second most recent index
8        
9        Arrays.fill(last, -1);
10        Arrays.fill(secondLast, -1);
11        
12        int ans = Integer.MAX_VALUE;
13        
14        for (int i = 0; i < n; i++) {
15            int x = nums[i];
16            
17            if (secondLast[x] != -1) {
18                ans = Math.min(ans, 2 * (i - secondLast[x]));
19            }
20            
21            secondLast[x] = last[x];
22            last[x] = i;
23        }
24        
25        return ans == Integer.MAX_VALUE ? -1 : ans;
26    }
27}