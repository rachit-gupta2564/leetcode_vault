// Last updated: 01/01/2026, 18:32:12
class Solution {
    public int mirrorDistance(int n) {
        int rev = reverse(n);
        return Math.abs(n - rev);
    }
    public int reverse(int n) {
        int rev = 0;
        while(n != 0) {
            int d = n % 10;
            rev = rev * 10 + d;
            n = n / 10;
        }
        return rev;
    }
}