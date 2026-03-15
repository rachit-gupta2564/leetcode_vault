// Last updated: 15/03/2026, 08:03:21
1import java.util.*;
2
3class Fancy {
4    private static final long MOD = 1_000_000_007L;
5
6    private List<Long> active;
7    private long mul;
8    private long add;
9
10    private int frozenCount;
11    private long frozenValue;
12
13    public Fancy() {
14        active = new ArrayList<>();
15        mul = 1;
16        add = 0;
17        frozenCount = 0;
18        frozenValue = 0;
19    }
20
21    public void append(int val) {
22        long raw = (val - add + MOD) % MOD;
23        raw = (raw * modPow(mul, MOD - 2)) % MOD;
24        active.add(raw);
25    }
26
27    public void addAll(int inc) {
28        add = (add + inc) % MOD;
29        frozenValue = (frozenValue + inc) % MOD;
30    }
31
32    public void multAll(int m) {
33        if (m == 0) {
34            frozenCount += active.size();
35            active.clear();
36            frozenValue = 0;
37            mul = 1;
38            add = 0;
39            return;
40        }
41
42        mul = (mul * m) % MOD;
43        add = (add * m) % MOD;
44        frozenValue = (frozenValue * m) % MOD;
45    }
46
47    public int getIndex(int idx) {
48        int totalSize = frozenCount + active.size();
49        if (idx >= totalSize) return -1;
50
51        if (idx < frozenCount) {
52            return (int) frozenValue;
53        }
54
55        long raw = active.get(idx - frozenCount);
56        return (int) ((raw * mul + add) % MOD);
57    }
58
59    private long modPow(long base, long exp) {
60        long result = 1;
61        base %= MOD;
62
63        while (exp > 0) {
64            if ((exp & 1) == 1) {
65                result = (result * base) % MOD;
66            }
67            base = (base * base) % MOD;
68            exp >>= 1;
69        }
70
71        return result;
72    }
73}
74