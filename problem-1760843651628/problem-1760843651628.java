// Last updated: 19/10/2025, 08:44:11
class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length, ans = 0;
        int max = 100000;
        int[] se = new int[max + 1];
        int[] so = new int[max + 1];
        int tag = 1;
        for (int i = 0; i < n; i++, tag++) {
            int de = 0, doo = 0;
            for (int j = i; j < n; j++) {
                int x = nums[j];
                if ((x & 1) == 0) {
                    if (se[x] != tag) {
                        se[x] = tag;
                        de++;
                    }
                } else {
                    if (so[x] != tag) {
                        so[x] = tag;
                        doo++;
                    }
                }
                if (de == doo) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}