// Last updated: 22/09/2025, 16:16:47
import java.util.HashMap;

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;
        int s1Len = s1.length(), s2Len = s2.length();
        int s1Count = 0, s2Count = 0, index = 0;
        HashMap<Integer, int[]> recall = new HashMap<>();
        
        while (s1Count < n1) {
            for (int i = 0; i < s1Len; i++) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;
                    if (index == s2Len) {
                        index = 0;
                        s2Count++;
                    }
                }
            }
            s1Count++;
            if (!recall.containsKey(index)) {
                recall.put(index, new int[]{s1Count, s2Count});
            } else {
                int[] prev = recall.get(index);
                int prevS1 = prev[0], prevS2 = prev[1];
                int cycleS1 = s1Count - prevS1;
                int cycleS2 = s2Count - prevS2;
                int remaining = n1 - s1Count;
                int times = remaining / cycleS1;
                s1Count += times * cycleS1;
                s2Count += times * cycleS2;
            }
        }
        return s2Count / n2;
    }
}
