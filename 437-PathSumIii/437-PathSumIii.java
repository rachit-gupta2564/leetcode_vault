// Last updated: 22/09/2025, 16:17:25
import java.util.*;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, 0L, targetSum, prefix);
    }
    
    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> prefix) {
        if (node == null) return 0;
        currSum += node.val;
        int res = prefix.getOrDefault(currSum - target, 0);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);
        res += dfs(node.left, currSum, target, prefix);
        res += dfs(node.right, currSum, target, prefix);
        prefix.put(currSum, prefix.get(currSum) - 1);
        return res;
    }
}
