// Last updated: 22/09/2025, 16:16:32
class Solution {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1;  // first three chars are "122"

        int[] s = new int[n + 1]; // use int array for efficiency
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int head = 2;  // pointer to read counts
        int tail = 3;  // pointer to write next number
        int num = 1;   // next number to write
        int count = 1; // already have one '1'

        while (tail < n) {
            for (int i = 0; i < s[head]; i++) {
                s[tail] = num;
                if (num == 1 && tail < n) count++;
                tail++;
            }
            num ^= 3;  // toggle between 1 and 2
            head++;
        }
        return count;
    }
}
