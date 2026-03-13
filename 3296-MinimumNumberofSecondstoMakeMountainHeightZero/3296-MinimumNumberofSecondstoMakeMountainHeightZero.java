// Last updated: 13/03/2026, 23:17:37
1class Solution {
2    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
3        int minWorker = Integer.MAX_VALUE;
4        for (int w : workerTimes) {
5            minWorker = Math.min(minWorker, w);
6        }
7
8        long left = 0;
9        long right = 1L * minWorker * mountainHeight * (mountainHeight + 1) / 2;
10
11        while (left < right) {
12            long mid = left + (right - left) / 2;
13            if (canFinish(mid, mountainHeight, workerTimes)) {
14                right = mid;
15            } else {
16                left = mid + 1;
17            }
18        }
19
20        return left;
21    }
22
23    private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {
24        long totalReduced = 0;
25
26        for (int w : workerTimes) {
27            long x = (long) ((Math.sqrt(1.0 + 8.0 * time / w) - 1.0) / 2.0);
28
29            while (1L * w * x * (x + 1) / 2 > time) {
30                x--;
31            }
32            while (1L * w * (x + 1) * (x + 2) / 2 <= time) {
33                x++;
34            }
35
36            totalReduced += x;
37            if (totalReduced >= mountainHeight) {
38                return true;
39            }
40        }
41
42        return false;
43    }
44}
45