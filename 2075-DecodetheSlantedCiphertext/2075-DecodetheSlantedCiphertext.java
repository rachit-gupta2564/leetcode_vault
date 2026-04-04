// Last updated: 04/04/2026, 18:02:06
1class Solution {
2    public String decodeCiphertext(String encodedText, int rows) {
3        if (rows == 0 || encodedText.length() == 0) return "";
4        
5        int cols = encodedText.length() / rows;
6        StringBuilder sb = new StringBuilder();
7        
8        for (int startCol = 0; startCol < cols; startCol++) {
9            int r = 0, c = startCol;
10            while (r < rows && c < cols) {
11                sb.append(encodedText.charAt(r * cols + c));
12                r++;
13                c++;
14            }
15        }
16        
17        int end = sb.length() - 1;
18        while (end >= 0 && sb.charAt(end) == ' ') {
19            end--;
20        }
21        
22        return sb.substring(0, end + 1);
23    }
24}