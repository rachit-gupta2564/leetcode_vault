// Last updated: 22/09/2025, 16:17:07
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // Use a priority queue (max heap) to sort by frequency
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> freqMap.get(b) - freqMap.get(a)
        );
        
        pq.addAll(freqMap.keySet());
        
        // Build the result string
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = freqMap.get(c);
            for (int i = 0; i < count; i++) sb.append(c);
        }
        
        return sb.toString();
    }
}
