// Last updated: 22/09/2025, 16:17:29
class Solution {
    public int countSegments(String s) {
        if (s == null || s.isEmpty()) return 0;
        String[] parts = s.trim().split("\\s+");
        return parts.length == 1 && parts[0].isEmpty() ? 0 : parts.length;
    }
}
