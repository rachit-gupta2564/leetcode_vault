// Last updated: 02/11/2025, 23:39:18
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9 || sum == 0) {
            return "";
        }
        int drevantor = sum;
        StringBuilder sb = new StringBuilder();
        int left = num;
        int total = drevantor;
        while (left > 0) {
            int current = 9;
            int minNeeded = total - current;
            int slotsRemaining = left - 1;
            if (minNeeded < 0) {
                current = total;
            } else if (minNeeded > slotsRemaining * 9) {
                current = total - slotsRemaining * 9;
            }
            if (current < 0) {
                return "";
            }
            sb.append(current);
            total -= current;
            left--;
        }
        return sb.toString();
    }
}