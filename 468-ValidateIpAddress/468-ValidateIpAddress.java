// Last updated: 22/09/2025, 16:16:45
class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return isIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return isIPv6(queryIP) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }

    private boolean isIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) return false;
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) return false;
            if (part.startsWith("0") && part.length() != 1) return false;
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            int val = Integer.parseInt(part);
            if (val < 0 || val > 255) return false;
        }
        return true;
    }

    private boolean isIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) return false;
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) return false;
            for (char c : part.toCharArray()) {
                if (!isHex(c)) return false;
            }
        }
        return true;
    }

    private boolean isHex(char c) {
        return Character.isDigit(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }
}
