// Last updated: 22/09/2025, 16:18:26
import java.util.*;

public class RandomizedSet {
    private final Map<Integer, Integer> idx;
    private final List<Integer> vals;
    private final Random rand;

    public RandomizedSet() {
        idx = new HashMap<>();
        vals = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (idx.containsKey(val)) return false;
        idx.put(val, vals.size());
        vals.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer i = idx.get(val);
        if (i == null) return false;
        int lastIndex = vals.size() - 1;
        if (i != lastIndex) {
            int lastVal = vals.get(lastIndex);
            vals.set(i, lastVal);
            idx.put(lastVal, i);
        }
        vals.remove(lastIndex);
        idx.remove(val);
        return true;
    }

    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
}
