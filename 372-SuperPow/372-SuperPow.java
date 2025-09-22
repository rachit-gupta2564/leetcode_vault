// Last updated: 22/09/2025, 16:18:36
class Solution {
    private static final int MOD = 1337;
    public int superPow(int a, int[] b) {
        a %= MOD;
        int res = 1;
        for (int digit : b) {
            res = (int)((long)powMod(res, 10) * powMod(a, digit) % MOD);
        }
        return res;
    }
    private int powMod(int a, int k) {
        long result = 1;
        long base = a % MOD;
        while (k > 0) {
            if ((k & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            k >>= 1;
        }
        return (int) result;
    }
}
