// Last updated: 22/09/2025, 16:17:02
import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // sort greed factors
        Arrays.sort(s); // sort cookie sizes
        
        int child = 0, cookie = 0;
        
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                // assign cookie to child
                child++;
            }
            cookie++; // move to next cookie
        }
        
        return child; // number of content children
    }
}
