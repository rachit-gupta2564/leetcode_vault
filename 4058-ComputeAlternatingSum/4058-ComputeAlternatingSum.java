// Last updated: 22/10/2025, 19:38:51
class Solution {
    public int alternatingSum(int[] nums) {
        int sum = 0, i = 0;
        while (i + 1 < nums.length)
            {
                sum += nums[i] - nums[i + 1];
                i += 2;
            }
        if (i < nums.length)
        {
            sum += nums[i];
        }
        return sum;
    }
}