// Last updated: 22/09/2025, 16:17:30
import java.util.*;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> valid = new HashSet<>(Arrays.asList(bank));
        if (!valid.contains(end)) return -1;
        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(end)) return steps;
                char[] arr = curr.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char old = arr[j];
                    for (char g : genes) {
                        if (g == old) continue;
                        arr[j] = g;
                        String next = new String(arr);
                        if (valid.contains(next) && visited.add(next)) {
                            q.offer(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            steps++;
        }
        return -1;
    }
}
