// Last updated: 22/09/2025, 16:15:04
class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] s = Integer.toString(n).toCharArray();
        java.util.Arrays.sort(s);
        String sortedN = new String(s);
        for (int i = 0; i <= 30; i++) {
            char[] p = Integer.toString(1 << i).toCharArray();
            java.util.Arrays.sort(p);
            if (sortedN.equals(new String(p))) return true;
        }
        return false;
    }
}
