// Last updated: 16/09/2025, 23:15:30
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int write = 0;
        int i = 0;
        while (i < n) {
            int val = nums[i];
            int cnt = 0;
            while (i < n && nums[i] == val) {
                if (cnt < 2) nums[write++] = val;
                cnt++;
                i++;
            }
        }
        return write;
    }
}
