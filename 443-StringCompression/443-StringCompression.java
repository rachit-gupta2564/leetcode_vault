// Last updated: 22/09/2025, 16:17:18
class Solution {
    public int compress(char[] chars) {
        int write = 0, i = 0;
        int n = chars.length;
        while (i < n) {
            char c = chars[i];
            int count = 0;
            while (i < n && chars[i] == c) {
                i++;
                count++;
            }
            chars[write++] = c;
            if (count > 1) {
                String cntStr = Integer.toString(count);
                for (char ch : cntStr.toCharArray()) {
                    chars[write++] = ch;
                }
            }
        }
        return write;
    }
}
