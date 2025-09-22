// Last updated: 22/09/2025, 16:16:31
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Iterate from end to start
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                if (count == k) {
                    sb.append('-');
                    count = 0;
                }
                sb.append(Character.toUpperCase(c));
                count++;
            }
        }

        // Reverse the string to get correct order
        return sb.reverse().toString();
    }
}
