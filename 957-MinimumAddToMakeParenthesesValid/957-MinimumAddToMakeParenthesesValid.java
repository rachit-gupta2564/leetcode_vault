// Last updated: 22/09/2025, 16:14:43
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else {
                if (open > 0) open--;
                else res++;
            }
        }
        return res + open;
    }
}
