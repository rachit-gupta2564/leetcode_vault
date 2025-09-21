// Last updated: 21/09/2025, 18:13:20
class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        return 1 + (num - 1) % 9;
    }
}
