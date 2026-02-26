// Last updated: 26/02/2026, 18:46:08
1class Solution {
2    public int[] sortByBits(int[] arr) {
3        Integer[] boxed = new Integer[arr.length];
4        for (int i = 0; i < arr.length; i++) boxed[i] = arr[i];
5
6        Arrays.sort(boxed, (a, b) -> {
7            int ca = Integer.bitCount(a);
8            int cb = Integer.bitCount(b);
9            if (ca != cb) return ca - cb;   // fewer 1s first
10            return a - b;                   // tie-break by value
11        });
12
13        for (int i = 0; i < arr.length; i++) arr[i] = boxed[i];
14        return arr;
15    }
16}