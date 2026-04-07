// Last updated: 07/04/2026, 21:30:41
1class Robot {
2    private final int[][] pos;
3    private final String[] dir;
4    private final int cycle;
5    private int idx;
6    private boolean moved;
7
8    public Robot(int width, int height) {
9        cycle = 2 * (width + height) - 4;
10        pos = new int[cycle][2];
11        dir = new String[cycle];
12
13        int k = 0;
14
15        // (0,0) is stored as "South" for the cycle-state after a full loop
16        pos[k][0] = 0;
17        pos[k][1] = 0;
18        dir[k] = "South";
19        k++;
20
21        for (int x = 1; x < width; x++) {
22            pos[k][0] = x;
23            pos[k][1] = 0;
24            dir[k] = "East";
25            k++;
26        }
27
28        for (int y = 1; y < height; y++) {
29            pos[k][0] = width - 1;
30            pos[k][1] = y;
31            dir[k] = "North";
32            k++;
33        }
34
35        for (int x = width - 2; x >= 0; x--) {
36            pos[k][0] = x;
37            pos[k][1] = height - 1;
38            dir[k] = "West";
39            k++;
40        }
41
42        for (int y = height - 2; y >= 1; y--) {
43            pos[k][0] = 0;
44            pos[k][1] = y;
45            dir[k] = "South";
46            k++;
47        }
48
49        idx = 0;
50        moved = false;
51    }
52
53    public void step(int num) {
54        moved = true;
55        idx = (idx + num % cycle) % cycle;
56    }
57
58    public int[] getPos() {
59        return new int[]{pos[idx][0], pos[idx][1]};
60    }
61
62    public String getDir() {
63        return moved ? dir[idx] : "East";
64    }
65}