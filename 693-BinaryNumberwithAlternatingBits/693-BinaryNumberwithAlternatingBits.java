// Last updated: 18/02/2026, 22:12:27
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        String sum = "";
4        int rem = 0;
5        while (n > 0)
6        {
7            rem = n % 2;
8            sum += rem;
9            n /= 2;
10        }
11        for (int i = sum.length() - 1; i > 0; i --) {
12            if (sum.charAt(i) == sum.charAt(i - 1)) {
13                return false;
14            }
15        }
16        return true;
17    }
18}