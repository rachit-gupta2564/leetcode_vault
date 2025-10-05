// Last updated: 05/10/2025, 09:24:52
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