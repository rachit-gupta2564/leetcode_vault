// Last updated: 22/09/2025, 16:18:42
class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target == 0) return true;
        if (x + y < target) return false;
        return target % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
