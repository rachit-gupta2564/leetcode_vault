// Last updated: 15/09/2025, 22:05:02
class Solution {
    public int earliestTime(int[][] tasks) {
        if (tasks == null || tasks.length == 0)
        {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int[] t : tasks)
            {
                if (t == null || t.length < 2)
                {
                    continue;
                }
                min = Math.min(min, t[0] + t[1]);
            }
        return min;
    }
}