// Last updated: 22/09/2025, 16:16:42
class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;
        int sum = 0;
        for (int stick : matchsticks) sum += stick;
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks); // sort in descending order for better pruning
        int[] sides = new int[4];
        return dfs(matchsticks, 0, sides, target);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > target) continue;
            sides[i] += matchsticks[index];
            if (dfs(matchsticks, index + 1, sides, target)) return true;
            sides[i] -= matchsticks[index];
        }
        return false;
    }

    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
