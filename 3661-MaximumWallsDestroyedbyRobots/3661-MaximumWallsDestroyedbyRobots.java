// Last updated: 04/04/2026, 18:00:32
1import java.util.*;
2
3class Solution {
4    public int maxWalls(int[] robots, int[] distance, int[] walls) {
5        int n = robots.length;
6        int m = walls.length;
7
8        int[][] arr = new int[n][2];
9        for (int i = 0; i < n; i++) {
10            arr[i][0] = robots[i];
11            arr[i][1] = distance[i];
12        }
13
14        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
15        Arrays.sort(walls);
16
17        int[] cntL = new int[n];
18        int[] cntR = new int[n];
19        int[] leftStart = new int[n];
20        int[] rightEnd = new int[n];
21
22        for (int i = 0; i < n; i++) {
23            int p = arr[i][0];
24            int d = arr[i][1];
25
26            int l = p - d;
27            if (i > 0) l = Math.max(l, arr[i - 1][0] + 1);
28
29            int r = p + d;
30            if (i + 1 < n) r = Math.min(r, arr[i + 1][0] - 1);
31
32            leftStart[i] = l;
33            rightEnd[i] = r;
34
35            cntL[i] = countInRange(walls, l, p);
36            cntR[i] = countInRange(walls, p, r);
37        }
38
39        int[] overlap = new int[n - 1];
40        for (int i = 0; i + 1 < n; i++) {
41            int l = leftStart[i + 1];
42            int r = rightEnd[i];
43            if (l <= r) {
44                overlap[i] = countInRange(walls, l, r);
45            }
46        }
47
48        int dpL = cntL[0];
49        int dpR = cntR[0];
50
51        for (int i = 1; i < n; i++) {
52            int newL = Math.max(dpL + cntL[i], dpR + cntL[i] - overlap[i - 1]);
53            int newR = Math.max(dpL + cntR[i], dpR + cntR[i]);
54            dpL = newL;
55            dpR = newR;
56        }
57
58        return Math.max(dpL, dpR);
59    }
60
61    private int countInRange(int[] walls, int left, int right) {
62        if (left > right) return 0;
63        return lowerBound(walls, right + 1) - lowerBound(walls, left);
64    }
65
66    private int lowerBound(int[] arr, int target) {
67        int l = 0, r = arr.length;
68        while (l < r) {
69            int mid = l + (r - l) / 2;
70            if (arr[mid] < target) l = mid + 1;
71            else r = mid;
72        }
73        return l;
74    }
75}