// Last updated: 16/09/2025, 23:15:32
import java.util.*;

class Solution {
    private static class Node { int r, c, idx; long mask; Node(int R,int C,int I,long M){r=R;c=C;idx=I;mask=M;} }
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int L = word.length();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                Deque<Node> st = new ArrayDeque<>();
                long startMask = 1L << (i * n + j);
                st.push(new Node(i, j, 1, startMask));
                while (!st.isEmpty()) {
                    Node cur = st.pop();
                    if (cur.idx == L) return true;
                    int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
                    for (int[] dir : d) {
                        int nr = cur.r + dir[0], nc = cur.c + dir[1];
                        if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                        int bit = nr * n + nc;
                        if (((cur.mask >> bit) & 1L) == 1L) continue;
                        if (board[nr][nc] != word.charAt(cur.idx)) continue;
                        long nm = cur.mask | (1L << bit);
                        st.push(new Node(nr, nc, cur.idx + 1, nm));
                    }
                }
            }
        }
        return false;
    }
}
