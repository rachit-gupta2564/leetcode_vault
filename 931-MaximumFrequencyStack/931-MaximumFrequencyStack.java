// Last updated: 22/09/2025, 16:14:51
import java.util.*;

class FreqStack {
    private Map<Integer, Integer> freq;
    private Map<Integer, Deque<Integer>> groups;
    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        groups = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        groups.computeIfAbsent(f, x -> new ArrayDeque<>()).push(val);
        if (f > maxFreq) maxFreq = f;
    }

    public int pop() {
        Deque<Integer> stack = groups.get(maxFreq);
        int val = stack.pop();
        freq.put(val, freq.get(val) - 1);
        if (stack.isEmpty()) {
            groups.remove(maxFreq);
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */