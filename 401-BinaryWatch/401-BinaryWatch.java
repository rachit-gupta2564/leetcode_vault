// Last updated: 17/02/2026, 22:36:47
1import java.util.*;
2
3class Solution {
4    public List<String> readBinaryWatch(int turnedOn) {
5        List<String> res = new ArrayList<>();
6        for (int h = 0; h < 12; h++) {
7            for (int m = 0; m < 60; m++) {
8                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
9                    res.add(h + ":" + (m < 10 ? "0" + m : m));
10                }
11            }
12        }
13        return res;
14    }
15}