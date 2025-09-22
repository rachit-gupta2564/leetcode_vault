// Last updated: 22/09/2025, 16:15:24
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age : ages) count[age]++;
        
        int result = 0;
        for (int a = 15; a <= 120; a++) {
            if (count[a] == 0) continue;
            for (int b = 15; b <= 120; b++) {
                if (count[b] == 0) continue;
                if (b <= 0.5 * a + 7) continue;
                if (b > a) continue;
                result += count[a] * (a == b ? count[b] - 1 : count[b]);
            }
        }
        return result;
    }
}
