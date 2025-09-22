// Last updated: 22/09/2025, 16:15:11
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] arr = s.toCharArray();
        long total = 0;
        for (int i = n - 1; i >= 0; --i) {
            total = (total + shifts[i]) % 26;
            int orig = arr[i] - 'a';
            arr[i] = (char) ((orig + total) % 26 + 'a');
        }
        return new String(arr);
    }
}
