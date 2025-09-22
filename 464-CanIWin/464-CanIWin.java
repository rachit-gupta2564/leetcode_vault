// Last updated: 22/09/2025, 16:16:49
import java.util.HashMap;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) return false;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return dfs(0, desiredTotal, maxChoosableInteger, memo);
    }
    
    private boolean dfs(int used, int desiredTotal, int maxChoosableInteger, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(used)) return memo.get(used);
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << (i - 1);
            if ((used & mask) == 0) {
                if (i >= desiredTotal || !dfs(used | mask, desiredTotal - i, maxChoosableInteger, memo)) {
                    memo.put(used, true);
                    return true;
                }
            }
        }
        memo.put(used, false);
        return false;
    }
}
