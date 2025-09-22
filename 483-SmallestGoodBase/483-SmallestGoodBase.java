// Last updated: 22/09/2025, 16:16:30
class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        // Maximum possible length of 1's in base k representation
        for (int m = (int)(Math.log(num) / Math.log(2)); m >= 1; m--) {
            long left = 2, right = (long)Math.pow(num, 1.0 / m) + 1;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long sum = 1, curr = 1;
                for (int i = 0; i < m; i++) {
                    curr *= mid;
                    sum += curr;
                    if (sum > num) break;
                }
                if (sum == num) return String.valueOf(mid);
                if (sum < num) left = mid + 1;
                else right = mid - 1;
            }
        }
        return String.valueOf(num - 1);
    }
}
