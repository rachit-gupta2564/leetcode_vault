// Last updated: 22/09/2025, 16:16:24
import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void backtrack(int[] nums, int index, List<Integer> temp, Set<List<Integer>> result) {
        if (temp.size() >= 2) result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (temp.isEmpty() || nums[i] >= temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                backtrack(nums, i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
