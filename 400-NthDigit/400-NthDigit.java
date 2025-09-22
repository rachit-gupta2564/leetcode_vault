// Last updated: 22/09/2025, 16:17:59
class Solution {
    public int findNthDigit(int n) {
        long digitLength = 1;
        long count = 9;
        long start = 1;

        // Find the range where the nth digit lies
        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        // Find the actual number that contains the nth digit
        start += (n - 1) / digitLength;
        String numStr = Long.toString(start);

        // Find the digit within the number
        return numStr.charAt((n - 1) % (int)digitLength) - '0';
    }
}
