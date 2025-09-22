// Last updated: 22/09/2025, 16:18:03
class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        long num = n; // use long to avoid overflow
        while (num != 1) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                if (num == 3 || ((num >>> 1) & 1) == 0) {
                    num--;
                } else {
                    num++;
                }
            }
            count++;
        }
        return count;
    }
}
