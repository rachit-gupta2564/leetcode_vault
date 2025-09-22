// Last updated: 22/09/2025, 16:14:14
class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = '\0';
        
        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
            } else {
                prev = c;
                count = 1;
            }
            if (count <= 2) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
