// Last updated: 22/09/2025, 16:18:25
import java.util.*;

public class RandomizedCollection {
    private final List<Integer> vals;
    private final Map<Integer, Set<Integer>> idx;
    private final Random rand;

    public RandomizedCollection() {
        vals = new ArrayList<>();
        idx = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !idx.containsKey(val) || idx.get(val).isEmpty();
        idx.computeIfAbsent(val, k -> new HashSet<>()).add(vals.size());
        vals.add(val);
        return notPresent;
    }

    public boolean remove(int val) {
        Set<Integer> positions = idx.get(val);
        if (positions == null || positions.isEmpty()) return false;
        int removePos = positions.iterator().next();
        positions.remove(removePos);

        int lastIndex = vals.size() - 1;
        int lastVal = vals.get(lastIndex);

        if (removePos != lastIndex) {
            vals.set(removePos, lastVal);
            Set<Integer> lastPositions = idx.get(lastVal);
            lastPositions.remove(lastIndex);
            lastPositions.add(removePos);
        }

        vals.remove(lastIndex);

        if (positions.isEmpty()) idx.remove(val);
        return true;
    }

    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
}
