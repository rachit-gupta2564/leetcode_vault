// Last updated: 22/09/2025, 16:16:59
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i, fast = i;
            boolean isForward = nums[i] > 0; // direction of movement

            while (true) {
                int nextSlow = nextIndex(nums, slow); 
                if (nums[nextSlow] == 0 || (nums[nextSlow] > 0) != isForward) break;

                int nextFast = nextIndex(nums, fast);
                if (nums[nextFast] == 0 || (nums[nextFast] > 0) != isForward) break;
                nextFast = nextIndex(nums, nextFast);
                if (nums[nextFast] == 0 || (nums[nextFast] > 0) != isForward) break;

                slow = nextSlow;
                fast = nextFast;

                if (slow == fast) {
                    if (slow == nextIndex(nums, slow)) break; // one-element loop
                    return true;
                }
            }

            // mark all nodes visited in this path as 0
            int j = i;
            while (nums[j] != 0 && (nums[j] > 0) == isForward) {
                int temp = nextIndex(nums, j);
                nums[j] = 0;
                j = temp;
            }
        }

        return false;
    }

    private int nextIndex(int[] nums, int i) {
        int n = nums.length;
        int next = (i + nums[i]) % n;
        return next >= 0 ? next : next + n;
    }
}
