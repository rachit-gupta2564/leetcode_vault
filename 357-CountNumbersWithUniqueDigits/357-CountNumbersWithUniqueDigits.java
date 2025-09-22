// Last updated: 22/09/2025, 16:18:44
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int ans = 10;
        int unique = 9;
        int available = 9;
        for (int i = 2; i <= n && available > 0; i++) {
            unique *= available;
            ans += unique;
            available--;
        }
        return ans;
    }
}
