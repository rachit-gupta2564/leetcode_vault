// Last updated: 22/09/2025, 16:16:00
import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;
        
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int maxCount = 1;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == maxFreq) maxCount++;
            else break;
        }
        
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}
