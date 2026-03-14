// Last updated: 14/03/2026, 20:12:19
1class Solution {
2    public int firstUniqueEven(int[] nums) {
3        Map<Integer, Integer> freq = new HashMap<>();
4        for (int x : nums) {
5            freq.put(x, freq.getOrDefault(x, 0) + 1);
6        }
7        for (int x : nums) {
8            if (x % 2 == 0 && freq.get(x) == 1) {
9                return x;
10            }
11        }
12        return -1;
13    }
14}