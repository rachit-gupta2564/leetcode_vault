// Last updated: 22/09/2025, 16:14:54
class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) size *= (c - '0');
            else size++;
        }
        long K = k;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int d = c - '0';
                size /= d;
                K %= size;
            } else {
                if (K == 0 || K == size) return String.valueOf(c);
                size--;
            }
        }
        return "";
    }
}
