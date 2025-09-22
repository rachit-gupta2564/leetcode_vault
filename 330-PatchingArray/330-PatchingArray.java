// Last updated: 22/09/2025, 16:19:20
class Solution {
    public int minPatches(int[] nums, int n) {
        long reach = 0;
        int patches = 0, i = 0;

        while (reach < n) {
            if (i < nums.length && nums[i] <= reach + 1) {
                reach += nums[i];
                i++;
            } else {
                reach += reach + 1; // patch with reach+1
                patches++;
            }
        }

        return patches;
    }
}
