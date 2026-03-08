// Last updated: 08/03/2026, 09:02:26
1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        StringBuilder sb = new StringBuilder();
4        for (int i = 0; i < nums.length; i++) {
5            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
6        }
7        return sb.toString();
8    }
9}
10