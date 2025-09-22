// Last updated: 22/09/2025, 16:18:48
import java.util.*;

/**
 * SummaryRanges data structure using a TreeMap of intervals.
 * Key: interval start
 * Value: interval end
 */
class SummaryRanges {
    private final TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int val) {
        // Find the interval with largest start <= val
        Map.Entry<Integer, Integer> lower = intervals.floorEntry(val);
        if (lower != null && val <= lower.getValue()) {
            // val is already covered by an existing interval
            return;
        }

        // Find the interval with smallest start > val
        Map.Entry<Integer, Integer> higher = intervals.ceilingEntry(val);

        boolean mergeLeft = (lower != null && lower.getValue() + 1 == val);
        boolean mergeRight = (higher != null && higher.getKey() - 1 == val);

        if (mergeLeft && mergeRight) {
            // Merge lower and higher with val bridging them
            int newStart = lower.getKey();
            int newEnd = higher.getValue();
            intervals.remove(lower.getKey());
            intervals.remove(higher.getKey());
            intervals.put(newStart, newEnd);
        } else if (mergeLeft) {
            // Extend the lower interval's end to include val
            intervals.put(lower.getKey(), lower.getValue() + 1);
        } else if (mergeRight) {
            // Remove higher and insert new interval starting at val
            int newEnd = higher.getValue();
            intervals.remove(higher.getKey());
            intervals.put(val, newEnd);
        } else {
            // No adjacent intervals, insert [val, val]
            intervals.put(val, val);
        }
    }

    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] res = new int[size][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : intervals.entrySet()) {
            res[i][0] = e.getKey();
            res[i][1] = e.getValue();
            i++;
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
