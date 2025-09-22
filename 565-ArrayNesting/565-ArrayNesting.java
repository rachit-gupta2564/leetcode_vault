// Last updated: 22/09/2025, 16:16:07
class Solution {
    public int arrayNesting(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {  // if not visited
                int start = i;
                int count = 0;
                while (nums[start] != -1) {
                    int next = nums[start];
                    nums[start] = -1;  // mark as visited
                    start = next;
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
}
