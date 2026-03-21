// Last updated: 22/03/2026, 01:16:04
1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3        for (int row = 0; row < k / 2; row++) {
4            int top = x + row;
5            int bottom = x + k - 1 - row;
6
7            for (int col = y; col < y + k; col++) {
8                int temp = grid[top][col];
9                grid[top][col] = grid[bottom][col];
10                grid[bottom][col] = temp;
11            }
12        }
13        return grid;
14    }
15}