// Last updated: 22/09/2025, 16:15:53
class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        int[] lastIndex = new int[10]; // store last index of each digit

        for (int i = 0; i < n; i++) {
            lastIndex[digits[i] - '0'] = i;
        }

        for (int i = 0; i < n; i++) {
            // try to find a bigger digit to swap with digits[i], starting from 9
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastIndex[d] > i) {
                    // swap digits[i] with the last occurrence of the bigger digit
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num; // no swap needed
    }
}
