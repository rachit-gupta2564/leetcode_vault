// Last updated: 22/09/2025, 16:16:55
import java.util.*;

class LFUCache {

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Integer> keyToVal;
    private final Map<Integer, Integer> keyToFreq;
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        increaseFreq(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }
        if (keyToVal.size() >= capacity) {
            LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
            int evictKey = keyList.iterator().next();
            keyList.remove(evictKey);
            if (keyList.isEmpty()) freqToKeys.remove(minFreq);
            keyToVal.remove(evictKey);
            keyToFreq.remove(evictKey);
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, ignore -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }
    
    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        LinkedHashSet<Integer> keyList = freqToKeys.get(freq);
        keyList.remove(key);
        if (keyList.isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) minFreq++;
        }
        freqToKeys.computeIfAbsent(freq + 1, ignore -> new LinkedHashSet<>()).add(key);
    }
}
