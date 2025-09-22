// Last updated: 22/09/2025, 16:18:08
class Solution {
    public boolean validUtf8(int[] data) {
        int remaining = 0;
        for (int b : data) {
            if (remaining == 0) {
                if ((b >> 5) == 0b110) remaining = 1;
                else if ((b >> 4) == 0b1110) remaining = 2;
                else if ((b >> 3) == 0b11110) remaining = 3;
                else if ((b >> 7) != 0) return false; // 1-byte must start with 0
            } else {
                if ((b >> 6) != 0b10) return false;
                remaining--;
            }
        }
        return remaining == 0;
    }
}
