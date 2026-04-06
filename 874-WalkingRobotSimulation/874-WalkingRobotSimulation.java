// Last updated: 06/04/2026, 19:26:04
1import java.util.HashSet;
2import java.util.Set;
3
4class Solution {
5    public int robotSim(int[] commands, int[][] obstacles) {
6        Set<Long> blocked = new HashSet<>();
7        for (int[] o : obstacles) {
8            blocked.add(encode(o[0], o[1]));
9        }
10
11        int[] dx = {0, 1, 0, -1};
12        int[] dy = {1, 0, -1, 0};
13
14        int x = 0, y = 0;
15        int dir = 0; // 0=N, 1=E, 2=S, 3=W
16        long maxDist = 0;
17
18        for (int cmd : commands) {
19            if (cmd == -1) {
20                dir = (dir + 1) % 4;
21            } else if (cmd == -2) {
22                dir = (dir + 3) % 4;
23            } else {
24                for (int step = 0; step < cmd; step++) {
25                    int nx = x + dx[dir];
26                    int ny = y + dy[dir];
27
28                    if (blocked.contains(encode(nx, ny))) {
29                        break;
30                    }
31
32                    x = nx;
33                    y = ny;
34                    maxDist = Math.max(maxDist, 1L * x * x + 1L * y * y);
35                }
36            }
37        }
38
39        return (int) maxDist;
40    }
41
42    private long encode(int x, int y) {
43        return (((long) x) << 32) ^ (y & 0xffffffffL);
44    }
45}