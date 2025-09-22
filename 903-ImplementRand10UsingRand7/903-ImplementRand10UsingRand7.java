// Last updated: 22/09/2025, 16:15:02
class Solution {
    // This is the given API.
    public int rand7() {
        return 1 + (int)(Math.random() * 7);
    }

    public int rand10() {
        int num;
        while (true) {
            // Generate a number from 1 to 49
            int r1 = rand7();
            int r2 = rand7();
            num = (r1 - 1) * 7 + r2; // num in [1,49]
            if (num <= 40) break; // accept 1-40
        }
        return 1 + (num - 1) % 10;
    }
}
