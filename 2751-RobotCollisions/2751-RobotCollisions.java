// Last updated: 04/04/2026, 17:55:33
1import java.util.*;
2
3class Solution {
4    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
5        int n = positions.length;
6        Integer[] idx = new Integer[n];
7        
8        for (int i = 0; i < n; i++) {
9            idx[i] = i;
10        }
11        
12        Arrays.sort(idx, (a, b) -> Integer.compare(positions[a], positions[b]));
13        
14        Deque<Integer> stack = new ArrayDeque<>();
15        
16        for (int i : idx) {
17            char dir = directions.charAt(i);
18            
19            if (dir == 'R') {
20                stack.push(i);
21            } else {
22                while (!stack.isEmpty() && healths[i] > 0) {
23                    int j = stack.peek();
24                    
25                    if (healths[j] < healths[i]) {
26                        stack.pop();
27                        healths[i]--;
28                        healths[j] = 0;
29                    } else if (healths[j] > healths[i]) {
30                        healths[j]--;
31                        healths[i] = 0;
32                    } else {
33                        stack.pop();
34                        healths[j] = 0;
35                        healths[i] = 0;
36                    }
37                }
38            }
39        }
40        
41        List<Integer> ans = new ArrayList<>();
42        for (int i = 0; i < n; i++) {
43            if (healths[i] > 0) {
44                ans.add(healths[i]);
45            }
46        }
47        
48        return ans;
49    }
50}