// Last updated: 01/03/2026, 08:17:07
1class Solution {
2    public String trimTrailingVowels(String s) {
3        for (int i = s.length() - 1; i >= 0; i --) {
4            char ch = s.charAt(i);
5            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
6                return s.substring(0, i + 1);
7            }
8        }
9        return "";
10    }
11}