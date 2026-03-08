// Last updated: 08/03/2026, 08:31:39
1class Solution {
2    public int smallestBalancedIndex(int[] nums) {
3        long sum = 0;
4        for (int x : nums) {
5            sum += x;
6        }
7        int n = nums.length;
8        long limit = sum + 1;
9        long[] sp = new long[n + 1];
10        sp[n] = 1;
11        for (int i = n - 1; i >= 0; i --) {
12            sp[i] = mc(sp[i + 1], nums[i], limit);
13        }
14        long left = 0;
15        for (int i = 0; i < n; i++) {
16            if (left == sp[i + 1]) {
17                return i;
18            }
19            left += nums[i];
20        }
21        return -1;
22    }
23    private long mc(long a, int b, long c) {
24        if (a > c / b) {
25            return c;
26        }
27        long v = a * b;
28        return Math.min(v, c);
29    }
30}