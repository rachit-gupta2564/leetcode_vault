// Last updated: 22/09/2025, 16:16:35
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int upper = (int) Math.pow(10, n) - 1;
        int lower = (int) Math.pow(10, n - 1);
        long maxNumber = (long) upper * upper;

        for (long firstHalf = maxNumber / (long) Math.pow(10, n); firstHalf >= lower; firstHalf--) {
            long palindrome = createPalindrome(firstHalf);
            for (long i = upper; i * i >= palindrome; i--) {
                if (palindrome % i == 0) {
                    long other = palindrome / i;
                    if (other >= lower && other <= upper) {
                        return (int)(palindrome % 1337);
                    }
                }
            }
        }
        return -1;
    }
    
    private long createPalindrome(long half) {
        long res = half;
        long temp = half;
        while (temp > 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        return res;
    }
}
